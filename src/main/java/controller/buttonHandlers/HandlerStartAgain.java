package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainMenuView;

public class HandlerStartAgain implements EventHandler<ActionEvent> {
    private Stage stage;

    public HandlerStartAgain(Stage stage) {
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent) {
        Scene scene = new Scene(new MainMenuView(this.stage));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
    }
}
