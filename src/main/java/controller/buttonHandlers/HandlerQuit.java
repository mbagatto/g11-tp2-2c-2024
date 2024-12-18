package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerQuit implements EventHandler<ActionEvent> {
    private SoundPlayer soundPlayer;

    public HandlerQuit() {
        this.soundPlayer = SoundPlayer.getInstance();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playButtonSound();
        Platform.exit();
    }
}
