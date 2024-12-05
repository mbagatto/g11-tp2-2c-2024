package controller;

import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer {

    private String buttonPath = "src/resources/sounds/button.wav";
    private String musicPath = "src/resources/sounds/music.wav";
    private String winPath = "src/resources/sounds/win.wav";
    private String tarotUpPath = "src/resources/sounds/tarotUp.wav";
    private String tarotDownPath = "src/resources/sounds/tarotDown.wav";
    private String jokerUpPath = "src/resources/sounds/jokerUp.wav";
    private String winRoundPath = "src/resources/sounds/winRound.wav";
    private Clip musicClip;

    public void playSound(String soundPath) {
        try {
            // Cargar el archivo de sonido
            File soundFile = new File(soundPath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }

    public void playButtonSound( ) {
        this.playSound(this.buttonPath);
    }

    public void playBackgroundMusic() {
        try {
            File musicFile = new File(musicPath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicFile);
            musicClip = AudioSystem.getClip();
            musicClip.open(audioIn);

            if (musicClip.isControlSupported(FloatControl.Type.VOLUME)) {
                FloatControl volumeControl = (FloatControl) musicClip.getControl(FloatControl.Type.VOLUME);
                float volume = 0.5f;  // Esto baja a la mitad el volumen si se puede
                volumeControl.setValue(volume);
            }
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicClip.start();

        } catch (Exception e) {
            System.out.println("Error al reproducir la música de fondo: " + e.getMessage());
        }
    }

    public void stopBackgroundMusic() {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop();
        }
    }

    public void pauseBackgroundMusic() {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop();
        }
    }

    public void resumeBackgroundMusic() {
        if (musicClip != null && !musicClip.isRunning()) {
            musicClip.start();
        }
    }

    public void playWinSound() {
        this.playSound(this.winPath);
    }

    public void playTarotUp() {
        this.playSound(this.tarotUpPath);
    }

    public void playTarotDown() {
        this.playSound(this.tarotDownPath);
    }

    public void playJokerUp() {
        this.playSound(this.jokerUpPath);
    }

    public void playWinRound() {
        this.playSound(this.winRoundPath);
    }

}
