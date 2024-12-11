package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Player;
import model.game.Round;
import view.GameOverView;

public class HandlerPlayHand implements EventHandler<ActionEvent> {
    private Player player;
    private Stage stage;
    private SoundPlayer soundPlayer;
    private Round round;

    public HandlerPlayHand(Player player, Stage stage, Round actualRound) {
        this.player = player;
        this.stage = stage;
        this.soundPlayer = SoundPlayer.getInstance();
        this.round = actualRound;
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        this.round.playHand(this.player);
        checkLoserStatus();
    }

    public void checkLoserStatus() {
        if (this.round.ranOutOfHands()) {
            GameOverView gameOverView = new GameOverView(this.stage);
        }
    }
}