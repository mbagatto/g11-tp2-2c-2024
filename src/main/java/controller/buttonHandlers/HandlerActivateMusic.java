package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandlerActivateMusic implements EventHandler<ActionEvent> {
    private Button modifyMusicButton;
    private SoundPlayer soundPlayer;

    public HandlerActivateMusic(Button modifyMusicButton, SoundPlayer soundPlayer) {
        this.modifyMusicButton = modifyMusicButton;
        this.soundPlayer = soundPlayer;
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.resumeBackgroundMusic();
        this.modifyMusicButton.setText("Desactivar Música");
        this.modifyMusicButton.setOnAction(new HandlerDeactivateMusic(this.modifyMusicButton, this.soundPlayer));
    }
}
