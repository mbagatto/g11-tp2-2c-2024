package view.buttons;

import controller.buttonHandlers.HandlerPlayHand;
import javafx.scene.control.Button;
import view.PlayerObserver;
import view.RoundObserver;

import java.util.List;


public class ButtonPlayHand extends Button {
    public ButtonPlayHand(PlayerObserver playerObserver, RoundObserver roundObserver, List<Integer> indexsCards) {
        super("Jugar Mano");
        this.setId("button-play-hand");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setOnAction(new HandlerPlayHand(playerObserver,roundObserver,indexsCards));
    }
}
