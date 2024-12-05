package view.buttons;

import controller.SoundPlayer;
import controller.buttonHandlers.HandlerWin;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.OnLaunchView;

public class ButtonWin extends Button {
    public ButtonWin(Stage stage) {

        super("Ir a menu");
        this.setId("button-next-round");
        this.setPrefWidth(350);
        this.setPrefHeight(80);
        setOnAction(new HandlerWin(stage));

    }
}
