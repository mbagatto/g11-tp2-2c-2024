package view.buttons;

import controller.buttonHandlers.HandlerNextGame;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;

public class ButtonNextGame extends Button {

    public ButtonNextGame(Stage stage, Player player, Round round, Game game) {
        super("Siguiente Juego");
        this.setId("button-next-game");
        this.setPrefWidth(350);
        this.setPrefHeight(80);
        this.setOnAction(new HandlerNextGame(stage, player, round, game));
    }
}
