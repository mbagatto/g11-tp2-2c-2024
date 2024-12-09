package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.buttons.ButtonMusic;

public class HandlerActivateMusic implements EventHandler<ActionEvent> {
    private ButtonMusic musicButton;

    public HandlerActivateMusic(ButtonMusic musicButton) {
        this.musicButton = musicButton;
    }

    public void handle(ActionEvent actionEvent) {
        this.musicButton.unmute();
    }
}
