package view.buttons;

import controller.buttonHandlers.HandlerNextRound;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;
import view.PlayerJokersView;
import view.PlayerTarotsView;

public class ButtonNextRound extends Button {
    public ButtonNextRound(Stage stage, Player player, Round round, Game game, PlayerJokersView playerJokersView, PlayerTarotsView playerTarotsView) {
        super("Siguiente Ronda");
        this.setId("button-next-round");
        this.setPrefWidth(350);
        this.setPrefHeight(80);
        this.setOnAction(new HandlerNextRound(stage, player, round, game, playerJokersView, playerTarotsView));
    }
}
