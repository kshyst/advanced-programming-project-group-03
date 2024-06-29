package Server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ir.ap.probending.Model.User;

import java.io.*;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Server extends Thread {
    private static final String USERS_FILE = "users.json";
    private static List<User> users = new ArrayList<>();
    private Socket socket;
    private User currentUser = null;

    public Server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String message = dataInputStream.readUTF().trim();
                if (message.equals("exit")) {
                    break;
                }
                String[] messageParts = message.split(" ");
                String command = messageParts[0];
                String response = "";
                System.out.println(message);
                switch (command) {
                    case "signup":
                        if (messageParts.length != 5)
                            response = "Invalid input";
                        else
                            response = signUp(messageParts[1], messageParts[2], messageParts[3], messageParts[4]);
                        System.out.println(response);
                        dataOutputStream.writeUTF(response);
                        dataOutputStream.flush();
                        break;
                    case "login":
                        if (messageParts.length != 3)
                            response = "Invalid input";
                        else
                            response = login(messageParts[1], messageParts[2]);
                        System.out.println(response);
                        dataOutputStream.writeUTF(response);
                        dataOutputStream.flush();
                        break;
                    case "sendEmail":
                        response = sendEmail();
                        System.out.println(response);
                        dataOutputStream.writeUTF(response);
                        dataOutputStream.flush();
                        break;
                    case "getUser":
                        User user = getUser();
                        Gson gson = new Gson();
                        System.out.println(response);
                        String userJson = gson.toJson(user);
                        dataOutputStream.writeUTF(userJson);
                        dataOutputStream.flush();
                        break;
                    case "saveUser":
                        String userString = message.substring(9);
                        Gson gson1 = new Gson();
                        User user1 = gson1.fromJson(userString, User.class);
                        saveUser(user1);
                        dataOutputStream.writeUTF("");
                        dataOutputStream.flush();
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized String signUp(String username, String password, String email, String nickname) {
        if (users == null) {
            User user = new User(username, password, email, nickname);
            users.add(user);
            saveUsersToFile();

            return "Signed up successfully.";
        }

        if (users.stream().anyMatch(user -> user.getUsername().equals(username))) {
            return "Username already exists";
        } else if (users.stream().anyMatch(user -> user.getEmail().equals(email))) {
            return "Email already exists";
        } else if (users.stream().anyMatch(user -> user.getNickname().equals(nickname))) {
            return "Nickname already exists";
        } else {
            User user = new User(username, password, email, nickname);
            users.add(user);
            currentUser = user;
            saveUsersToFile();

            return "Signed up successfully.";
        }
    }

    private synchronized String login(String username, String password) {
        if (users == null) {
            return "User not found";
        }

        User user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
        if (user == null) {
            return "User not found";
        } else if (!user.getPassword().equals(password)) {
            return "Incorrect password";
        } else {
            currentUser = user;
            return "Sending email confirmation link";
        }
    }

    private User getUser() {
        return currentUser;
    }

    private void saveUser(User user) {
        if (user.getUsername().equals(currentUser.getUsername())) {
            currentUser = user;
        }
        users.removeIf(u -> u.getUsername().equals(user.getUsername()));
        users.add(user);
        saveUsersToFile();
    }

    private String sendEmail() {
        if (currentUser == null) {
            return "Email not found";
        }
        Random random = new Random();
        int confirmationCode = 100000 + random.nextInt(900000);
        String confirmationCodeStr = String.valueOf(confirmationCode);
        currentUser.setLoginNumber(confirmationCodeStr);
        MailSender mailSender = new MailSender();
        try {
            mailSender.sendEmailWithCode(currentUser.getEmail(), confirmationCode);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send email";
        }
        return confirmationCodeStr;
    }
    private static void loadUsersFromFile() {
        File file = new File(USERS_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (Reader reader = new FileReader(USERS_FILE)) {
            Gson gson = new Gson();
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            users = gson.fromJson(reader, userListType);
            if (users == null) {
                users = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Users file not found. Starting with an empty user list.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveUsersToFile() {
        try (Writer writer = new FileWriter(USERS_FILE)) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        loadUsersFromFile();

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Socket socket = serverSocket.accept();
                Server server = new Server(socket);
                server.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
