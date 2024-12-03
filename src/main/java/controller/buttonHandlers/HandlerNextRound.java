package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import view.GameView;

public class HandlerNextRound  implements EventHandler<ActionEvent> {
    private Stage stage;
    private Player player;

    public HandlerNextRound(Stage stage,Player player) {
        this.stage = stage;
        this.player = player;
    }

    public void handle(ActionEvent actionEvent) {
        Scene gameScene = new Scene(new GameView(this.stage,this.player));
        gameScene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        this.stage.setScene(gameScene);
        this.stage.setFullScreen(true);
        this.stage.setFullScreenExitHint("");
    }
}
