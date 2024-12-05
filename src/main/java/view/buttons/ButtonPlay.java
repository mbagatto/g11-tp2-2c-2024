package view.buttons;

import controller.buttonHandlers.HandlerPlay;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Player;

public class ButtonPlay extends Button {
    public ButtonPlay(Stage stage, Player player) {
        super("Jugar");
        this.setId("button-play");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setOnAction(new HandlerPlay(stage, player));
    }
}
