package view;

import controller.buttonHandlers.HandlerStart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ButtonStart extends Button {

    public ButtonStart(Stage stage, TextField text, Label errorLabel) {
        super("Start Game");
        this.setMinWidth(200);
        this.setMinHeight(30);
        this.setStyle("-fx-cursor: hand; -fx-font-size: 20px;");
        this.setOnAction(new HandlerStart(stage, text, errorLabel));
    }
}
