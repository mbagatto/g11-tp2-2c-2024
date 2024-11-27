package controller;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SoundPlayer {

    public void playSound(String soundFilePath) {
        try {
            URL soundPath = getClass().getResource(soundFilePath);
            if (soundPath == null) {
                System.err.println("Error: Archivo de sonido no encontrado en " + soundFilePath);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
