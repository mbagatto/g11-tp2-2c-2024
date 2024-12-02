package view;

import controller.buttonHandlers.HandlerPlay;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Player;

public class ButtonPlay extends Button {

    public ButtonPlay(Stage stage, Player player) {
        super("PLAY");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setStyle(
                "-fx-background-color: rgb(0,104,216);"
                + "-fx-text-fill: white;"
                + "-fx-font-size: 50px; "
                + "-fx-cursor: hand;"
        );
        this.setOnAction(new HandlerPlay(stage, player));
    }
}