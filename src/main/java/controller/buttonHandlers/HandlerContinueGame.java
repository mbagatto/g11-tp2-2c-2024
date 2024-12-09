package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;

public class HandlerContinueGame implements EventHandler<ActionEvent> {
    private Stage stage;
    private Group groupView;
    private SoundPlayer soundPlayer;

    public HandlerContinueGame(Stage stage, Group groupView) {
        this.stage = stage;
        this.groupView = groupView;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        this.stage.setScene(this.groupView.getScene());
    }
}
