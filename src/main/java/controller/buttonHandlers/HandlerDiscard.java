package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.game.Game;
import view.buttons.ButtonDiscard;

public class HandlerDiscard implements EventHandler<ActionEvent> {
    private SoundPlayer soundPlayer;
    private Game game;
    private ButtonDiscard discardButton;

    public HandlerDiscard(Game game, ButtonDiscard discardButton) {
        this.soundPlayer = SoundPlayer.getInstance();
        this.game = game;
        this.discardButton = discardButton;
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        this.game.discardHand();
        if (this.game.ranOutOfDiscards()) {
            this.discardButton.setDisable(true);
        }
    }
}
