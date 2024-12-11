package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.game.Game;
import view.MainMenuView;
import view.PreparationView;

public class HandlerNewRound implements EventHandler<ActionEvent> {
    private Stage stage;
    private MainMenuView mainMenuView;
    private Game game;

    public HandlerNewRound(Stage stage, MainMenuView mainMenuView, Game game) {
        this.stage = stage;
        this.mainMenuView = mainMenuView;
        this.game = game;
    }

    public void handle(ActionEvent actionEvent) {
        Scene scene = new Scene(new PreparationView(this.stage, this.mainMenuView, this.game));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        this.stage.setScene(scene);
    }
}
