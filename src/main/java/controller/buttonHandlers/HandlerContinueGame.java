package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.PreparationView;

public class HandlerContinueGame implements EventHandler<ActionEvent> {
    private Stage stage;
    private PreparationView preparationView;
    private SoundPlayer soundPlayer;

    public HandlerContinueGame(Stage stage, PreparationView pView) {
        this.stage = stage;
        this.preparationView = pView;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        this.stage.setScene(this.preparationView.getScene());
    }
}
