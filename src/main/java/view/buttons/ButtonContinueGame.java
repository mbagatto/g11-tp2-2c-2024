package view.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonContinueGame extends Button {
    public ButtonContinueGame(Stage stage) {
        super("Continue Game");
        this.setId("main-menu-button");
        this.setPrefWidth(525);
        this.setPrefHeight(95);
    }

    public void setHandler(EventHandler<ActionEvent> handler) {
        this.setOnAction(handler);
    }
}
