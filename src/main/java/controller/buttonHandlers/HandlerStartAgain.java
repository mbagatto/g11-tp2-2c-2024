package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainMenuView;

public class HandlerStartAgain implements EventHandler<ActionEvent> {
    private Stage stage;
    private SoundPlayer soundPlayer;

    public HandlerStartAgain(Stage stage) {
        this.stage = stage;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playBackgroundMusic();
        Scene scene = new Scene(new MainMenuView(this.stage));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
    }
}
