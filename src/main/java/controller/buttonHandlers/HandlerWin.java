package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.OnLaunchView;

public class HandlerWin implements EventHandler<ActionEvent> {
    private Stage stage;
    public HandlerWin(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
//        SoundPlayer soundPlayer = new SoundPlayer();
//        soundPlayer.playBackgroundMusic();
        OnLaunchView onLaunchView = new OnLaunchView(stage);

        VBox vbox = new VBox(); // Esto se podria remover
        vbox.getChildren().add(onLaunchView);

        Scene scene = new Scene(vbox);
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
        stage.setFullScreen(true);
    }
}
