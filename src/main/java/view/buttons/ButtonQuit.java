package view.buttons;

import controller.buttonHandlers.HandlerQuit;
import javafx.scene.control.Button;

public class ButtonQuit extends Button {
    public ButtonQuit() {
        super("Salir");
        this.setId("button-quit");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setOnAction(new HandlerQuit());
    }
}