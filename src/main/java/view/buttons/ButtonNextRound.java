package view.buttons;

import controller.buttonHandlers.HandlerNextRound;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.dtos.GameDTO;
import view.MainMenuView;

public class ButtonNextRound extends Button {
    public ButtonNextRound(Stage stage, MainMenuView mainMenuView, GameDTO gameDTO) {
        super("Siguiente Ronda");
        this.setId("button-next-round");
        this.setPrefWidth(350);
        this.setPrefHeight(80);
        this.setDefaultButton(true);
        this.setOnAction(new HandlerNextRound(stage, mainMenuView, gameDTO));
    }
}
