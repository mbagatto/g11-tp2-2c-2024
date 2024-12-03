package view.buttons;

import controller.buttonHandlers.HandlerPlayHand;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import view.PlayerObserver;
import view.RoundObserver;

import java.util.List;


public class ButtonPlayHand extends Button {

    private final String initialState = "-fx-background-color: #0087F2; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #0087F2; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;";

    private final String hoverState = "-fx-background-color: #005094; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #005094; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;";

    public ButtonPlayHand(PlayerObserver playerObserver, RoundObserver roundObserver, List<Integer> indexsCards) {
        super("Jugar Mano");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setStyle(this.initialState);
        this.setOnMouseEntered(e -> this.setStyle(hoverState));
        this.setOnMouseExited(e -> this.setStyle(initialState));
        this.setOnAction(new HandlerPlayHand(playerObserver,roundObserver,indexsCards));
    }
}
