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
import model.reader.DataReader;
import view.MenuView;

import java.util.ArrayList;

public class HandlerStart implements EventHandler<ActionEvent> {
    private TextField text;
    private Label errorLabel;
    private Stage stage;
    private SoundPlayer soundPlayer;

    public HandlerStart(Stage stage, TextField text, Label errorLabel) {
        this.stage = stage;
        this.text = text;
        this.errorLabel = errorLabel;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playSound("src/resources/sounds/button.ogg");
        if (!this.text.getText().trim().isEmpty()) {
            EnglishDeck englishDeck = new EnglishDeck();
            englishDeck.fillDeck();
            Player player = new Player(this.text.getText(), englishDeck);
            Scene scene = new Scene(new MenuView(stage, player));
            scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
            stage.setScene(scene);
        } else {
            errorLabel.setVisible(true);
        }
    }
}
