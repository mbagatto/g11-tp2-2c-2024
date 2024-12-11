package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Player;
import model.game.Round;
import view.RoundWonView;
import view.RoundLostView;

public class HandlerPlayHand implements EventHandler<ActionEvent> {
    private Stage stage;
    private Group previousScene;
    private Player player;
    private SoundPlayer soundPlayer;
    private Round round;

    public HandlerPlayHand(Stage stage, Group previousScene, Player player, Round actualRound) {
        this.stage = stage;
        this.previousScene = previousScene;
        this.player = player;
        this.soundPlayer = SoundPlayer.getInstance();
        this.round = actualRound;
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        this.round.playHand(this.player);
        checkLoserStatus();
    }

    public void checkLoserStatus() {
        PauseTransition pause = new PauseTransition(Duration.seconds(0.25));

        if (this.round.wonRound()) {
            pause.setOnFinished(event -> {
                this.previousScene.getChildren().add(new RoundWonView(this.stage));
            });
        } else if (this.round.ranOutOfHands()) {
            pause.setOnFinished(event -> {
                this.previousScene.getChildren().add(new RoundLostView(this.stage));
            });
        }

        pause.play();
    }
}