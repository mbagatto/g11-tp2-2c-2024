package view.buttons;

import controller.SoundPlayer;
import controller.buttonHandlers.HandlerActivateMusic;
import controller.buttonHandlers.HandlerDeactivateMusic;
import javafx.scene.control.Button;
import view.MainMenuView;

public class ButtonMusic extends Button {
    private SoundPlayer soundPlayer;
    private MainMenuView mainMenuView;

    public ButtonMusic() {
        super();
        this.setId("music-button");
        this.setPrefWidth(250);
        this.soundPlayer = SoundPlayer.getInstance();
        this.unmute();
    }

    public void mute() {
        this.soundPlayer.pauseBackgroundMusic();
        this.setText("Activar Música");
        this.setOnAction(new HandlerActivateMusic(this));
    }

    public void unmute() {
        this.soundPlayer.resumeBackgroundMusic();
        this.setText("Desactivar Música");
        this.setOnAction(new HandlerDeactivateMusic(this));
    }
}
