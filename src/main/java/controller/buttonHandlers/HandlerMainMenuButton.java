package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.MainMenuView;
import view.buttons.ButtonYellow;

public class HandlerMainMenuButton implements EventHandler<ActionEvent> {
    private Stage stage;
    private MainMenuView mainMenuView;
    private Group groupView;
    private SoundPlayer soundPlayer;

    public HandlerMainMenuButton(Stage stage, MainMenuView mainMenuView, Group groupView) {
        this.stage = stage;
        this.mainMenuView = mainMenuView;
        this.groupView = groupView;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playButtonSound();
        this.mainMenuView.getChildren().remove(5);

        Button continueButton = new ButtonYellow("Continuar");
        continueButton.setOnAction(new HandlerContinueGame(this.stage, this.groupView));
        this.mainMenuView.getChildren().add(5, continueButton);

        this.groupView.getChildren().removeLast();

        this.stage.setScene(this.mainMenuView.getScene());
    }
}
