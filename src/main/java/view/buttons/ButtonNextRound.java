package view.buttons;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonNextRound extends Button {
    public ButtonNextRound(Stage stage) {
        super("Siguiente Ronda");
        this.setId("button-next-round");
        this.setPrefWidth(350);
        this.setPrefHeight(80);
//        this.setOnAction(new HandlerNextRound());
    }
}
