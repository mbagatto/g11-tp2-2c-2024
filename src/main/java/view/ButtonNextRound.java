package view;

import controller.buttonHandlers.HandlerNextRound;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonNextRound extends Button {

    public ButtonNextRound(Stage stage) {
        super("Next Round");
        this.setId("button-next-round");
        this.setPrefWidth(450);
        this.setPrefHeight(75);
        this.setOnAction(new HandlerNextRound(stage));
    }
}
