package controller;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import view.Interface;


public class Controller {

    private Interface view;

    public Controller(Interface view) {
        this.view = view;
    }

    public void handleNameButtonAction(String name, Stage stage, Label errorLabel) {
        if (name != null && !name.trim().isEmpty()) {
            view.showMenuScene();
        } else {
            errorLabel.setVisible(true);
        }
    }
}

