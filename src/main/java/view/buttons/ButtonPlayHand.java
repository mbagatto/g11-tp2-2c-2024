package view.buttons;

import controller.buttonHandlers.HandlerPlayHand;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.game.Game;
import view.MainMenuView;

public class ButtonPlayHand extends Button {

    public ButtonPlayHand(Stage stage, Group previousScene, Game game, MainMenuView mainMenuView) {
        super("Jugar Mano");
        this.setId("button-blue");
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setOnAction(new HandlerPlayHand(stage, previousScene, game, mainMenuView));
    }
}
