package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;
import view.MainMenuView;
import view.PreparationView;
import view.buttons.ButtonContinueGame;

public class HandlerMainMenuButton extends StageButtonHandler {
    private MainMenuView mainMenuView;
    private PreparationView preparationView;
    private SoundPlayer soundPlayer;

    public HandlerMainMenuButton(MainMenuView mainMenuView, PreparationView pView) {
        this.mainMenuView = mainMenuView;
        this.preparationView = pView;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent actionEvent) {
        Stage stage = getStage(actionEvent);
        this.soundPlayer.playButtonSound();
        this.mainMenuView.getChildren().removeLast();
        ButtonContinueGame continueButton = new ButtonContinueGame();
        continueButton.setHandler(new HandlerContinueGame(stage, this.preparationView));
        this.mainMenuView.getChildren().add(continueButton);
        stage.setScene(this.mainMenuView.getScene());
    }
}
