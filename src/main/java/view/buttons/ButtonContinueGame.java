package view.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonContinueGame extends Button {
    public ButtonContinueGame() {
        super("Continuar");
        this.setId("main-menu-button");
        this.setPrefWidth(525);
        this.setPrefHeight(95);
    }

    public void setHandler(EventHandler<ActionEvent> handler) {
        this.setOnAction(handler);
    }
}
