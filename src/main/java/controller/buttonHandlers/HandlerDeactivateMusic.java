package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.buttons.ButtonMusic;

public class HandlerDeactivateMusic implements EventHandler<ActionEvent> {
    private ButtonMusic musicButton;

    public HandlerDeactivateMusic(ButtonMusic musicButton) {
        this.musicButton = musicButton;
    }

    public void handle(ActionEvent actionEvent) {
        this.musicButton.mute();
    }
}
