package view.buttons;

import controller.buttonHandlers.HandlerDiscard;
import javafx.scene.control.Button;
import model.Player;
import model.game.Round;

public class ButtonDiscard extends Button {

    public ButtonDiscard(Player player, Round actualRound) {
        super("Descartar");
        this.setId("button-red");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setOnAction(new HandlerDiscard(actualRound, player));
    }
}
