package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;

public class HandlerContinueGame extends StageButtonHandler {
    private Group groupView;
    private SoundPlayer soundPlayer;

    public HandlerContinueGame(Group groupView) {
        this.groupView = groupView;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        Stage stage = getStage(event);
        stage.setScene(groupView.getScene());
    }
}
