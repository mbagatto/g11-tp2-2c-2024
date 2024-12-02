package controller.buttonHandlers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerQuit implements EventHandler<ActionEvent> {

    public void handle(ActionEvent actionEvent) {
        Platform.exit();
    }
}
