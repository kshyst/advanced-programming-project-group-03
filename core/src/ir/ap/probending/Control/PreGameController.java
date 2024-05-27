package ir.ap.probending.Control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import ir.ap.probending.Model.Card.Card;
import ir.ap.probending.Model.Card.CardsInfo;
import ir.ap.probending.Model.Data.GameAssetManager;
import ir.ap.probending.Model.ScreenMasterSetting;
import ir.ap.probending.ProBending;

import java.util.ArrayList;


public class PreGameController {
    private static PreGameController preGameController = new PreGameController(ScreenMasterSetting.getInstance().getPreGameScreen().getStage());
    private final Table table = new Table();
    Card card = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card2 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card3 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card4 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card5 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card6 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card7 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card8 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card9 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card10 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card11 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card12 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card13 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card14 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card15 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card16 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card17 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card18 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    Card card19 = new Card(CardsInfo.Amon.getAbility() , CardsInfo.Amon.getName() , CardsInfo.Amon.getDescription() , CardsInfo.Amon.getPower() , CardsInfo.Amon.isHero() , new Texture(Gdx.files.internal(CardsInfo.Amon.getPictureLocation()))  , CardsInfo.Amon.getPlayingRow());
    private final Table storageTable = new Table();
    private final Table deckTable = new Table();
    private ScrollPane storageScrollPane = new ScrollPane(storageTable);
    private ScrollPane deckScrollPane = new ScrollPane(deckTable);
    private ScrollPane.ScrollPaneStyle scrollPaneStyle ;
    private ScrollPane.ScrollPaneStyle storageScrollPaneStyle;
    private ScrollPane.ScrollPaneStyle deckScrollPaneStyle ;
    private final Stage stage ;
    private ArrayList<Card> deckCards = new ArrayList<>();
    private ArrayList<Card> storageCards = new ArrayList<>();
    Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
    Pixmap pixmap2 = new Pixmap(1, 1, Pixmap.Format.RGBA8888);

    private PreGameController(Stage stage) {
        this.stage = stage;
        table.setSkin(GameAssetManager.getGameAssetManager().getSkin());
        table.setFillParent(true);
        table.center();
        scrollPaneStyle = GameAssetManager.getGameAssetManager().getSkin().get("default", ScrollPane.ScrollPaneStyle.class);

        storageTable.setSkin(GameAssetManager.getGameAssetManager().getSkin());
        storageTable.top().left();
        storageScrollPane.setScrollingDisabled(true, false);
        storageScrollPane.setScrollbarsVisible(true);
        storageScrollPane.setFadeScrollBars(false);
        storageScrollPane.setSmoothScrolling(true);
        storageScrollPane.setScrollBarPositions(false, true);
        storageScrollPaneStyle = new ScrollPane.ScrollPaneStyle(scrollPaneStyle);
        storageScrollPane.setStyle(storageScrollPaneStyle);

        deckTable.setSkin(GameAssetManager.getGameAssetManager().getSkin());
        deckTable.top().left();
        deckScrollPane.setScrollingDisabled(true, false);
        deckScrollPane.setScrollbarsVisible(true);
        deckScrollPane.setFadeScrollBars(false);
        deckScrollPane.setSmoothScrolling(true);
        deckScrollPane.setScrollBarPositions(false, true);
        deckScrollPaneStyle = new ScrollPane.ScrollPaneStyle(scrollPaneStyle);
        deckScrollPane.setStyle(deckScrollPaneStyle);

        stage.addActor(table);
        stage.addActor(storageScrollPane);
        stage.addActor(deckScrollPane);

        storageScrollPane.setPosition(60,190);
        deckScrollPane.setPosition((float) Gdx.graphics.getWidth() - 960,190);
        storageScrollPane.setSize(900, 700);
        deckScrollPane.setSize(900, 700);

        pixmap.setColor(Color.RED); // Replace with your color
        pixmap.fill();
        pixmap2.setColor(Color.BLUE); // Replace with your color
        pixmap2.fill();
        TextureRegionDrawable drawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
        TextureRegionDrawable drawable2 = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap2)));
        storageTable.setBackground(drawable);
        deckTable.setBackground(drawable2);

        addCardToStorage(card);
        addCardToStorage(card2);
        addCardToDeck(card3);
        addCardToDeck(card4);
        addCardToDeck(card5);
        addCardToDeck(card6);
        addCardToDeck(card7);
        addCardToDeck(card8);
        addCardToDeck(card9);
        addCardToDeck(card10);
        addCardToDeck(card11);
        addCardToDeck(card12);
        addCardToDeck(card13);
        addCardToDeck(card14);
        addCardToDeck(card15);
        addCardToDeck(card16);
        addCardToDeck(card17);
        addCardToDeck(card18);
        addCardToDeck(card19);

    }

    public void handlePreGameController(ProBending game) {

    }

    public void drawCards(SpriteBatch batch) {

    }

    public void addCardToDeck(Card card) {
        deckCards.add(card);
        refreshDeckTable();
    }

    public void addCardToStorage(Card card) {
        storageCards.add(card);
        refreshStorageTable();
    }

    public void removeCardFromDeck(Card card) {
        deckCards.remove(card);
        refreshDeckTable();
    }

    public void removeCardFromStorage(Card card) {
        storageCards.remove(card);
        refreshStorageTable();
    }

    private void refreshDeckTable() {
        deckTable.clear();
        for (int i = 0; i < deckCards.size(); i++) {
            if (i % 4 == 0) {
                deckTable.row();
            }
            deckTable.add(deckCards.get(i)).pad(10);
        }
    }

    private void refreshStorageTable() {
        storageTable.clear();
        for (int i = 0; i < storageCards.size(); i++) {
            if (i % 4 == 0) {
                storageTable.row();
            }
            storageTable.add(storageCards.get(i)).pad(10);
        }
    }

    //getters and setters

    public static PreGameController getPreGameController(){
        return preGameController;
    }

    public Table getTable() {
        return table;
    }

    public Table getStorageTable() {
        return storageTable;
    }

    public Table getDeckTable() {
        return deckTable;
    }

    public Stage getStage() {
        return stage;
    }
}
