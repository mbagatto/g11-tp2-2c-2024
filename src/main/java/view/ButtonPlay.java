package view;

import controller.buttonHandlers.HandlerPlay;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Player;

public class ButtonPlay extends Button {

    private final String initialState = "-fx-background-color: #0087F2; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #0087F2; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;" +
             "-fx-cursor: hand;";

    private final String hoverState = "-fx-background-color: #005094; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #005094; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;" +
            "-fx-cursor: hand;";

    public ButtonPlay(Stage stage, Player player) {
        super("PLAY");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setStyle(this.initialState);
        this.setOnMouseEntered(e -> this.setStyle(hoverState));
        this.setOnMouseExited(e -> this.setStyle(initialState));
        this.setOnAction(new HandlerPlay(stage, player));
    }
}
