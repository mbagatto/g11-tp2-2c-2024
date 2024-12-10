package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.Player;
import model.decks.EnglishDeck;
import model.game.Game;
import model.game.Round;
import model.reader.DataReader;
import view.MainMenuView;
import view.PreparationView;
import java.util.ArrayList;

public class HandlerPlay extends StageButtonHandler {
    private TextField playerName;
    private SoundPlayer soundPlayer;
    private Label errorLabel;

    public HandlerPlay(TextField playerName, Label errorLabel) {
        this.playerName = playerName;
        this.errorLabel = errorLabel;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        Stage stage = getStage(actionEvent);
        // Knowing that this button can only be found in the Main Menu
        MainMenuView mainMenuView = (MainMenuView) stage.getScene().getRoot();
        this.soundPlayer.playButtonSound();
        String playerName = this.playerName.getText();

        if (!playerName.trim().isEmpty()) {
            DataReader dataReader = new DataReader();
            EnglishDeck englishDeck = new EnglishDeck();
            englishDeck.fillDeck();
            ArrayList<Round> rounds = dataReader.roundsRead();

            Game game = new Game(new Player(playerName, englishDeck), rounds);

            Scene scene = new Scene(new PreparationView(mainMenuView, game.toDTO()));
            scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
            stage.setScene(scene);

        } else {
            this.errorLabel.setVisible(true);
        }
    }
}
