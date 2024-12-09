package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.MainMenuView;
import view.PreparationView;
import view.buttons.ButtonYellow;

public class HandlerMainMenuButton implements EventHandler<ActionEvent> {
    private Stage stage;
    private MainMenuView mainMenuView;
    private PreparationView preparationView;
    private SoundPlayer soundPlayer;

    public HandlerMainMenuButton(Stage stage, MainMenuView mainMenuView, PreparationView pView) {
        this.stage = stage;
        this.mainMenuView = mainMenuView;
        this.preparationView = pView;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playButtonSound();
        this.mainMenuView.getChildren().remove(5);

        Button continueButton = new ButtonYellow("Continuar");
        continueButton.setOnAction(new HandlerContinueGame(this.stage, this.preparationView));
        this.mainMenuView.getChildren().add(5, continueButton);

        this.preparationView.getChildren().removeLast();

        this.stage.setScene(this.mainMenuView.getScene());
    }
}
