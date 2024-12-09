package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.MainMenuView;
import view.OptionsMenuView;
import view.PreparationView;

public class HandlerOptionsButton implements EventHandler<ActionEvent> {
    private Stage stage;
    private MainMenuView mainMenuView;
    private PreparationView preparationView;

    public HandlerOptionsButton(Stage stage, MainMenuView mainMenuView, PreparationView pView) {
        this.stage = stage;
        this.mainMenuView = mainMenuView;
        this.preparationView = pView;
    }

    public void handle(ActionEvent actionEvent) {
        this.preparationView.getChildren().add(new OptionsMenuView(this.stage, this.mainMenuView, this.preparationView));
    }
}
