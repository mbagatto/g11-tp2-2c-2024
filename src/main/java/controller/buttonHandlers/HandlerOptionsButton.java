package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import view.MainMenuView;
import view.OptionsMenuView;

public class HandlerOptionsButton extends StageButtonHandler {
    private MainMenuView mainMenuView;
    private Group groupView;

    public HandlerOptionsButton(MainMenuView mainMenuView, Group groupView) {
        this.mainMenuView = mainMenuView;
        this.groupView = groupView;
    }

    public void handle(ActionEvent actionEvent) {
        Stage stage = getStage(actionEvent);
        this.groupView.getChildren().add(new OptionsMenuView(stage, this.mainMenuView, this.groupView));
    }
}
