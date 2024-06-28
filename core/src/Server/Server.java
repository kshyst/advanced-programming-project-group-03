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
                switch (command) {
                    case "signup":
                        response = signUp(messageParts[1], messageParts[2], messageParts[3], messageParts[4]);
                        dataOutputStream.writeUTF(response);
                        dataOutputStream.flush();
                        break;
                    case "login":
                        response = login(messageParts[1], messageParts[2]);
                        dataOutputStream.writeUTF(response);
                        dataOutputStream.flush();
                        break;
                    case "sendEmail":
                        response = sendEmail(messageParts[1]);
                        dataOutputStream.writeUTF(response);
                        dataOutputStream.flush();
                        break;
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized String signUp(String username, String password, String email, String nickname) {
        if (users.stream().anyMatch(user -> user.getUsername().equals(username))) {
            return "Username already exists";
        } else if (users.stream().anyMatch(user -> user.getEmail().equals(email))) {
            return "Email already exists";
        } else if (users.stream().anyMatch(user -> user.getNickname().equals(nickname))) {
            return "Nickname already exists";
        } else {
            User user = new User(username, password, email, nickname);
            users.add(user);
            saveUsersToFile();

            return "Signed up successfully.";
        }
    }

    private synchronized String login(String username, String password) {
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

    private String sendEmail(String recipientEmail) {
        final String senderEmail = "proBendingAvatar@gmail.com";
        final String senderPassword = "1234abcd!";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        // Generate a 6-digit random confirmation code
        Random random = new Random();
        int confirmationCode = 100000 + random.nextInt(900000);
        String confirmationCodeStr = String.valueOf(confirmationCode);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Email Confirmation Code");
            message.setText("Please use this code to confirm your email: " + confirmationCodeStr);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        // Return the confirmation code so it can be stored and compared later
        return confirmationCodeStr;
    }
    private static void loadUsersFromFile() {
        try (Reader reader = new FileReader(USERS_FILE)) {
            Gson gson = new Gson();
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
            users = gson.fromJson(reader, userListType);
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
