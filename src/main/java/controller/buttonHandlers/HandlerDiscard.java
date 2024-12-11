package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Player;
import model.game.Round;

public class HandlerDiscard implements EventHandler<ActionEvent> {
    private SoundPlayer soundPlayer;
    private Round round;
    private Player player;

    public HandlerDiscard(Round actualRound, Player player) {
        this.soundPlayer = SoundPlayer.getInstance();
        this.round = actualRound;
        this.player = player;
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        this.round.discardHand(this.player);
    }
}
