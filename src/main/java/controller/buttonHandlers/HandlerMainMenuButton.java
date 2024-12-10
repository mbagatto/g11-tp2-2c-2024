package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.stage.Stage;
import view.MainMenuView;
import view.buttons.ButtonYellow;

public class HandlerMainMenuButton extends StageButtonHandler {
    private MainMenuView mainMenuView;
    private Group groupView;
    private SoundPlayer soundPlayer;

    public HandlerMainMenuButton(MainMenuView mainMenuView, Group groupView) {
        this.mainMenuView = mainMenuView;
        this.groupView = groupView;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        Stage stage = getStage(actionEvent);
        this.soundPlayer.playButtonSound();
        this.mainMenuView.getChildren().removeLast();

        Button continueButton = new ButtonYellow("Continuar");
        continueButton.setOnAction(new HandlerContinueGame(this.groupView));
        this.mainMenuView.getChildren().add(continueButton);

        this.groupView.getChildren().removeLast();

        stage.setScene(this.mainMenuView.getScene());
    }
}
