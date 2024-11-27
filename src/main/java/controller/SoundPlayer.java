package controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

//public class SoundPlayer {
//
//    public void playSound(String soundFilePath) {
//        try {
//            URL soundPath = getClass().getResource(soundFilePath);
//            if (soundPath == null) {
//                System.err.println("Error: Archivo de sonido no encontrado en " + soundFilePath);
//                return;
//            }
//            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundPath);
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioStream);
//            clip.start();
//        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            e.printStackTrace();
//        }
//    }
//}

import javax.sound.sampled.*;

//public class SoundPlayer {
//
//    public void playSound(String filePath) {
//        try {
//            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(filePath));
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioIn);
//            clip.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {

    public void playSound(String soundFilePath) {
        try {
            // Cargar el archivo de sonido usando getClass().getResource()
            URL soundURL = getClass().getResource(soundFilePath);

            if (soundURL == null) {
                System.out.println("No se encontró el archivo de sonido en el path: " + soundFilePath);
                return;
            }

            // Abrir el AudioInputStream desde la URL
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);

            // Obtener un clip de audio y abrirlo
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Reproducir el sonido
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }
}
