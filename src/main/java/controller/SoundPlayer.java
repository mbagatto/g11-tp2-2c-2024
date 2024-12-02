package controller;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {

    public void playSound(String soundFilePath) {
        try {
            URL soundURL = getClass().getResource(System.getProperty("user.dir") + soundFilePath);
            if (soundURL == null) {
                System.out.println("The sound file was not found at the path: " + soundFilePath);
                return;
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }
}
