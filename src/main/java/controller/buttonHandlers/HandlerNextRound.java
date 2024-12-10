package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.game.GameDTO;
import view.MainMenuView;
import view.RoundGameView;

public class HandlerNextRound  extends StageButtonHandler {
    private MainMenuView mainMenuView;
    private GameDTO gameDTO;
    private SoundPlayer soundPlayer;

    public HandlerNextRound(MainMenuView mainMenuView, GameDTO gameDTO) {
        this.mainMenuView = mainMenuView;
        this.gameDTO = gameDTO;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        Stage stage = getStage(actionEvent);
        this.soundPlayer.playButtonSound();

        Scene scene = new Scene(new RoundGameView(this.mainMenuView, this.gameDTO));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
    }
}
