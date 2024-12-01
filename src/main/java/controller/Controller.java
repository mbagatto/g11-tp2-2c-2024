package controller;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import view.Interface;


public class Controller {

    private Interface view;
    private SoundPlayer soundPlayer;

    public Controller(Interface view) {
        this.view = view;
        this.soundPlayer = new SoundPlayer();
    }

    public void handleNameButtonAction(String name, Stage stage, Label errorLabel) {
        if (name != null && !name.trim().isEmpty()) {
            view.showMenuScene();
        } else {
            errorLabel.setVisible(true);
        }
    }

    public void handleButtonClick() {
        soundPlayer.playSound("src/resources/sounds/button2.wav");
    }

    public void handlePlayAction() {
        view.showGameScene();
    }
}

