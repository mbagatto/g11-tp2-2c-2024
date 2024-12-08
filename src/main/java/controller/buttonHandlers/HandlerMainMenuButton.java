package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.MainMenuView;
import view.PreparationView;
import view.buttons.ButtonContinueGame;

public class HandlerMainMenuButton implements EventHandler<ActionEvent> {
    private Stage stage;
    private MainMenuView mainMenuView;
    private PreparationView preparationView;
    private SoundPlayer soundPlayer;

    public HandlerMainMenuButton(Stage stage, MainMenuView mainMenuView, PreparationView pView) {
        this.stage = stage;
        this.mainMenuView = mainMenuView;
        this.preparationView = pView;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playButtonSound();
        this.mainMenuView.getChildren().removeLast();
        ButtonContinueGame continueButton = new ButtonContinueGame();
        continueButton.setHandler(new HandlerContinueGame(this.stage, this.preparationView));
        this.mainMenuView.getChildren().add(continueButton);
        this.stage.setScene(this.mainMenuView.getScene());
    }
}
