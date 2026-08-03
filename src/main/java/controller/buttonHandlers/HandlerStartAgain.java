package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import model.cards.Card;
import model.decks.EnglishDeck;
import model.game.Game;
import model.game.Round;
import model.reader.DataReader;
import view.MainMenuView;
import view.PreparationView;
import view.ScaledSceneFactory;

import java.util.ArrayList;

public class HandlerStartAgain implements EventHandler<ActionEvent> {
    private Stage stage;
    private String playerName;
    private SoundPlayer soundPlayer;

    public HandlerStartAgain(Stage stage, String playerName) {
        this.stage = stage;
        this.playerName = playerName;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playBackgroundMusic();

        DataReader dataReader = new DataReader();
        ArrayList<Card> cards = dataReader.cardsRead();
        ArrayList<Round> rounds = dataReader.roundsRead();

        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player(this.playerName, englishDeck);
        Game game = new Game(player, rounds);

        MainMenuView mainMenuView = new MainMenuView(this.stage);
        Scene scene = ScaledSceneFactory.create(new PreparationView(this.stage, mainMenuView, game));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        this.stage.setScene(scene);
        this.stage.setFullScreen(true);
    }
}
