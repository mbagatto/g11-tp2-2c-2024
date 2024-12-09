package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainMenuView;
import view.PreparationView;

public class HandlerContinueGame extends StageButtonHandler {
    private PreparationView preparationView;
    private SoundPlayer soundPlayer;

    public HandlerContinueGame(PreparationView preparationView) {
        this.preparationView = preparationView;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        Stage stage = getStage(event);
        stage.setScene(preparationView.getScene());
    }
}
