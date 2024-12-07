package view;

import controller.SoundPlayer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        SoundPlayer soundPlayer = new SoundPlayer();
        soundPlayer.playBackgroundMusic();

        Scene scene = new Scene(new MainMenuView(stage));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
