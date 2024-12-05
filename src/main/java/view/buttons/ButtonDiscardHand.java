package view.buttons;

import controller.buttonHandlers.HandlerDiscardHand;
import javafx.scene.control.Button;
import view.PlayerObserver;
import view.RoundObserver;
import java.util.List;

public class ButtonDiscardHand extends Button {
    public ButtonDiscardHand(PlayerObserver playerObserver, RoundObserver roundObserver, List<Integer> indexsCards) {
        super("Descartar");
        this.setId("button-discard-hand");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setOnAction(new HandlerDiscardHand(playerObserver,roundObserver,indexsCards));
    }

}
