package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;
import view.PreparationView;

public class HandlerNextGame implements EventHandler<ActionEvent> {
    private Stage stage;
    private Player player;
    private Round round;
    private Game game;

    public HandlerNextGame(Stage stage, Player player, Round round, Game game) {
        this.stage = stage;
        this.player = player;
        this.round = round;
        this.game = game;
    }

    public void handle(ActionEvent actionEvent) {
        Scene scene = new Scene(new PreparationView(this.stage, this.round, this.player, this.game));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
    }
}