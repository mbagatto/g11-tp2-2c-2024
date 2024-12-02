package view;

import controller.buttonHandlers.HandlerNextRound;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonNextRound extends Button {

    public ButtonNextRound(Stage stage) {
        super("Next Round");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setStyle(
                "-fx-font-size: 45px;"
                + "-fx-background-color: rgba(251,56,56,0.5);"
                + "-fx-text-fill: rgba(255,255,255,0.97);"
                + "-fx-background-radius: 10px;"
                + "-fx-cursor: hand;"
        );
        this.setOnAction(new HandlerNextRound(stage));
    }
}
