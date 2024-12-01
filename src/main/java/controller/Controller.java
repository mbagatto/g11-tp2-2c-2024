package controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;
import model.reader.RoundReader;
import view.Interface;

import java.util.ArrayList;


public class Controller {

    private Interface view;
    private SoundPlayer soundPlayer;

    public Controller(Interface view) {
        this.view = view;
        this.soundPlayer = new SoundPlayer();
    }

    public void handleNameButtonAction(String name, Label errorLabel) {
        if (name != null && !name.trim().isEmpty()) {
            view.showMenuScene(name);
        } else {
            errorLabel.setVisible(true);
        }
    }

    public void handleButtonClick() {
        soundPlayer.playSound("/resources/sounds/button.ogg");
    }

    public void handlePlayAction(String playerName) {
        Player player = new Player(playerName);
        Game game = new Game(player);
        view.showRoundMenuScene(game);
    }

    public void handleQuitAction(Scene scene) {
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }
}

