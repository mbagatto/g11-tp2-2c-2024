package view.buttons;

import controller.SoundPlayer;
import javafx.scene.control.Button;

public class ButtonMusic extends Button {
    private SoundPlayer soundPlayer;

    public ButtonMusic() {
        super();
        this.setId("music-button");
        this.setPrefWidth(250);
        this.soundPlayer = SoundPlayer.getInstance();
        this.update();
    }

    public void update() {
        if (this.soundPlayer.isPlayingMusic()) {
            this.setText("Desactivar Musica");
            this.setOnAction(_ -> {
                this.soundPlayer.pauseBackgroundMusic();
                this.update();
            });
        } else {
            this.setText("Activar Musica");
            this.setOnAction(_ -> {
                this.soundPlayer.resumeBackgroundMusic();
                this.update();
            });
        }
    }
}
