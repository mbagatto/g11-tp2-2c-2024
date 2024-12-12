package view.buttons;

import controller.buttonHandlers.HandlerOptionsButton;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import view.MainMenuView;

public class ButtonOptions extends Button {
    private boolean escPressed = false;

    public ButtonOptions(Stage stage, MainMenuView mainMenuView, Group groupView) {
        super("Opciones");
        this.setId("options-button");
        this.setLayoutX(100);
        this.setLayoutY(900);
        this.setPrefWidth(300);
        this.setPrefHeight(80);
        this.setOnAction(new HandlerOptionsButton(stage, mainMenuView, groupView));

        groupView.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE && !this.escPressed) {
                this.escPressed = true;
                this.fire();
            }
        });
    }
}
