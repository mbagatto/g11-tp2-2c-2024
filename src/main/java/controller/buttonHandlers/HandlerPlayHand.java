package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.game.Game;
import view.MainMenuView;
import view.RoundWonView;
import view.RoundLostView;
import view.WonGameView;

public class HandlerPlayHand implements EventHandler<ActionEvent> {
    private Stage stage;
    private Group previousScene;
    private SoundPlayer soundPlayer;
    private Game game;
    private MainMenuView mainMenuView;

    public HandlerPlayHand(Stage stage, Group previousScene, Game game, MainMenuView mainMenuView) {
        this.stage = stage;
        this.previousScene = previousScene;
        this.soundPlayer = SoundPlayer.getInstance();
        this.game = game;
        this.mainMenuView = mainMenuView;
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        this.game.playHand();
        checkLoserStatus();
    }

    public void checkLoserStatus() {
        PauseTransition pause = new PauseTransition(Duration.seconds(0.25));

        if (this.game.wonGame()) {
            pause.setOnFinished(event -> {
                this.previousScene.getChildren().add(new WonGameView(this.stage));
            });
        } else if (this.game.wonRound()) {
            pause.setOnFinished(event -> {
                this.previousScene.getChildren().add(new RoundWonView(this.stage, this.mainMenuView, this.game));
            });
            this.game.setNextRound();
        } else if (this.game.ranOutOfHands()) {
            pause.setOnFinished(event -> {
                this.previousScene.getChildren().add(new RoundLostView(this.stage));
            });
        }

        pause.play();
    }
}
