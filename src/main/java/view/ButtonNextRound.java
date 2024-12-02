package view;

import controller.buttonHandlers.HandlerNextRound;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonNextRound extends Button {

    public ButtonNextRound(Stage stage) {
        super("Next Round");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setOnAction(new HandlerNextRound(stage));
    }
}
