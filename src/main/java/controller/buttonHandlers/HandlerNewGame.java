package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Player;
import model.cards.Card;
import model.decks.EnglishDeck;
import model.game.Game;
import model.game.Round;
import model.reader.DataReader;
import view.MainMenuView;
import view.PreparationView;
import java.util.ArrayList;

public class HandlerNewGame implements EventHandler<ActionEvent> {
    private Stage stage;
    private MainMenuView mainMenuView;
    private TextField playerName;
    private SoundPlayer soundPlayer;
    private Label errorLabel;

    public HandlerNewGame(Stage stage, MainMenuView mainMenuView, TextField playerName, Label errorLabel) {
        this.stage = stage;
        this.mainMenuView = mainMenuView;
        this.playerName = playerName;
        this.errorLabel = errorLabel;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playButtonSound();
        String playerName = this.playerName.getText();

        if (!playerName.trim().isEmpty()) {
            DataReader dataReader = new DataReader();

            ArrayList<Card> cards = dataReader.cardsRead();
            ArrayList<Round> rounds = dataReader.roundsRead();

            EnglishDeck englishDeck = new EnglishDeck();
            englishDeck.fillDeck(cards);
            Player user = new Player(playerName, englishDeck);
            Game game = new Game(user, rounds);

            Scene scene = new Scene(new PreparationView(this.stage, this.mainMenuView, game));
            scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
            stage.setScene(scene);

        } else {
            this.errorLabel.setVisible(true);
        }
    }
}
