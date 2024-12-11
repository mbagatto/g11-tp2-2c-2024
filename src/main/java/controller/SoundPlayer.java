package controller;

import javax.sound.sampled.*;
import java.io.File;

public final class SoundPlayer { //Aplica Singleton

    private String buttonPath = "src/resources/sounds/button.wav";
    private String musicPath = "src/resources/sounds/music.wav";
    private String winPath = "src/resources/sounds/win.wav";
    private String tarotUpPath = "src/resources/sounds/tarotUp.wav";
    private String tarotDownPath = "src/resources/sounds/tarotDown.wav";
    private String jokerUpPath = "src/resources/sounds/jokerUp.wav";
    private String jokerDownPath = "src/resources/sounds/jokerDown.wav";
    private String winRoundPath = "src/resources/sounds/winRound.wav";
    private String cardUpPath = "src/resources/sounds/cardUp.wav";
    private String cardDownPath = "src/resources/sounds/cardDown.wav";
    private String maxSelectedPath = "src/resources/sounds/maxSelected.wav";
    private String losePath = "src/resources/sounds/lose.wav";
    private Clip musicClip;
    private static SoundPlayer instance;

    private SoundPlayer() {}

    public static SoundPlayer getInstance() {
        if (instance == null) {
            instance = new SoundPlayer();
        }
        return instance;
    }

    public void playSound(String soundPath) {
        try {
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

    public void playJokerDown() {
        this.playSound(this.jokerDownPath);
    }

    public void playWinRound() {
        this.playSound(this.winRoundPath);
    }

    public boolean isPlayingMusic() {
        return musicClip != null && musicClip.isRunning();
    }

    public void playCardUp() {
        this.playSound(this.cardUpPath);
    }

    public void playCardDown() {
        this.playSound(this.cardDownPath);
    }

    public void playMaxSelected() {
        this.playSound(this.maxSelectedPath);
    }

    public void playLose() {
        this.playSound(this.losePath);
    }
}
