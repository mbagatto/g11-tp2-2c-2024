package view.buttons;

import controller.buttonHandlers.HandlerPlayHand;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Player;
import model.game.Round;

public class ButtonPlayHand extends Button {

    public ButtonPlayHand(Stage stage, Group previousScene, Player player, Round actualRound) {
        super("Jugar Mano");
        this.setId("button-blue");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setOnAction(new HandlerPlayHand(stage, previousScene, player, actualRound));
    }
}
