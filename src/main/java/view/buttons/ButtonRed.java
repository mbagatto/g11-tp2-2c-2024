package view.buttons;

import javafx.scene.control.Button;

public class ButtonRed extends Button {
    public ButtonRed(String text) {
        super(text);
        this.setId("button-red");
        this.setPrefWidth(315);
        this.setPrefHeight(95);
    }
}