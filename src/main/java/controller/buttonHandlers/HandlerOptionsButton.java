package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import view.MainMenuView;
import view.OptionsMenuView;

public class HandlerOptionsButton implements EventHandler<ActionEvent> {
    private Stage stage;
    private MainMenuView mainMenuView;
    private Group groupView;
    private SoundPlayer soundPlayer;

    public HandlerOptionsButton(Stage stage, MainMenuView mainMenuView, Group groupView) {
        this.stage = stage;
        this.mainMenuView = mainMenuView;
        this.groupView = groupView;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playButtonSound();
        this.groupView.getChildren().add(new OptionsMenuView(this.stage, this.mainMenuView, this.groupView));
    }
}
