package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

public abstract class StageButtonHandler implements EventHandler<ActionEvent> {

    protected Stage getStage(ActionEvent event) {
        return (Stage) ((Node)event.getSource()).getScene().getWindow();
    }
}
