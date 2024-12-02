package view;

import controller.buttonHandlers.HandlerQuit;
import javafx.scene.control.Button;

public class ButtonQuit extends Button {

    public ButtonQuit() {
        super("QUIT");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setStyle(
                "-fx-background-color: rgb(248,74,74);"
                + "-fx-text-fill: white;"
                + "-fx-font-size: 50px; "
                + "-fx-cursor: hand;"
        );
        this.setOnAction(new HandlerQuit());
    }
}
