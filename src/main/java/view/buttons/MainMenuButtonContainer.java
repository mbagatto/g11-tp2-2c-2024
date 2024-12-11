package view.buttons;

import controller.buttonHandlers.HandlerNewGame;
import controller.buttonHandlers.HandlerQuit;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.MainMenuView;

public class MainMenuButtonContainer extends HBox {
    public MainMenuButtonContainer(Stage stage, MainMenuView mainMenuView, TextField playerName, Label errorLabel) {
        super(12);
        this.setId("menu-button-container");
        this.setAlignment(Pos.CENTER);

        Button playButton = new ButtonBlue("Nueva Partida");
        playButton.setOnAction(new HandlerNewGame(stage, mainMenuView, playerName, errorLabel));
        playButton.setDefaultButton(true);

        Button quitButton = new ButtonRed("Salir");
        quitButton.setOnAction(new HandlerQuit());

        this.getChildren().add(playButton);
        this.getChildren().add(quitButton);
    }
}
