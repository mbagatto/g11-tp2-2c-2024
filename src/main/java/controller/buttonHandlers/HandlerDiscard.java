package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.game.Game;

public class HandlerDiscard implements EventHandler<ActionEvent> {
    private SoundPlayer soundPlayer;
    private Game game;

    public HandlerDiscard(Game game) {
        this.soundPlayer = SoundPlayer.getInstance();
        this.game = game;
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        this.game.discardHand();
    }
}
