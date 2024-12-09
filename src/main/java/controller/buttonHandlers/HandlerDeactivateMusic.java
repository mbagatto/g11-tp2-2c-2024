package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandlerDeactivateMusic implements EventHandler<ActionEvent> {
    private Button modifyMusicButton;
    private SoundPlayer soundPlayer;

    public HandlerDeactivateMusic(Button modifyMusicButton, SoundPlayer soundPlayer) {
        this.modifyMusicButton = modifyMusicButton;
        this.soundPlayer = soundPlayer;
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.pauseBackgroundMusic();
        this.modifyMusicButton.setText("Activar Música");
        this.modifyMusicButton.setOnAction(new HandlerActivateMusic(this.modifyMusicButton, this.soundPlayer));
    }
}
