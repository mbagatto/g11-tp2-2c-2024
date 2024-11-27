package controller;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.Interface;


public class Controller {

    private Interface view;
    private SoundPlayer soundPlayer;
    private final String buttonSoundPath = "file:src/resources/sounds/button.ogg";

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
        soundPlayer.playSound(buttonSoundPath);
    }
}

