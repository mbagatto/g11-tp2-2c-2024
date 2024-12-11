package view.buttons;

import controller.buttonHandlers.HandlerNextRound;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.game.Game;
import view.MainMenuView;

public class ButtonNextRound extends Button {
    public ButtonNextRound(Stage stage, MainMenuView mainMenuView, Game game) {
        super("Siguiente Ronda");
        this.setId("button-next-round");
        this.setPrefWidth(350);
        this.setPrefHeight(80);
        this.setDefaultButton(true);
        this.setOnAction(new HandlerNextRound(stage, mainMenuView, game));
    }
}
