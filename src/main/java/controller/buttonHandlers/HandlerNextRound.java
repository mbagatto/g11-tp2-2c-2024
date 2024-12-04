package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;
import view.GameView;

public class HandlerNextRound  implements EventHandler<ActionEvent> {
    private Stage stage;
    private Player player;
    private Round round;
    private Game game;

    public HandlerNextRound(Stage stage, Player player, Round round, Game game) {
        this.stage = stage;
        this.player = player;
        this.round = round;
        this.game = game;
    }

    public void handle(ActionEvent actionEvent) {
        Scene gameScene = new Scene(new GameView(this.stage,this.player, this.round,this.game));
        gameScene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        this.stage.setScene(gameScene);
        this.stage.setFullScreen(true);
        this.stage.setFullScreenExitHint("");
    }
}
