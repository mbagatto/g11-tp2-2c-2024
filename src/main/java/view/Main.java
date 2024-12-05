package view;

import controller.SoundPlayer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private OnLaunchView onLaunchView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        SoundPlayer soundPlayer = new SoundPlayer();
        soundPlayer.playBackgroundMusic();


        onLaunchView = new OnLaunchView(stage);

        VBox vbox = new VBox(); // Esto se podria remover
        vbox.getChildren().add(onLaunchView);

        Scene scene = new Scene(vbox);
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }
}
