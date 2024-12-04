package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;
import model.reader.DataReader;
import view.PreparationView;
import java.util.ArrayList;

public class HandlerPlay implements EventHandler<ActionEvent> {
    private Stage stage;
    private Player player;

    public HandlerPlay(Stage stage, Player player) {
        this.stage = stage;
        this.player = player;
    }

    public void handle(ActionEvent actionEvent) {
        DataReader dataReader = new DataReader();
        ArrayList<Round> rounds = dataReader.roundsRead();
        Game game = new Game(this.player, rounds);
        Round round = game.nextRound();
        Scene scene = new Scene(new PreparationView(stage, round, this.player,game));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
    }
}
