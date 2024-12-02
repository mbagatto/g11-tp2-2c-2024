package view;

import controller.buttonHandlers.HandlerQuit;
import javafx.scene.control.Button;

public class ButtonQuit extends Button {

    private final String initialState = "-fx-background-color: #FF453F; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #FF453F; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;";

    private final String hoverState = "-fx-background-color: #6e0300; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #6e0300; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;";

    public ButtonQuit() {
        super("QUIT");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
//        this.setStyle(
//                "-fx-background-color: rgb(248,74,74);"
//                + "-fx-text-fill: white;"
//                + "-fx-font-size: 50px; "
//                + "-fx-cursor: hand;"
//        );
        this.setStyle(this.initialState);
        this.setOnMouseEntered(e -> this.setStyle(this.hoverState));
        this.setOnMouseExited(e -> this.setStyle(this.initialState));
        this.setOnAction(new HandlerQuit());
    }
}



