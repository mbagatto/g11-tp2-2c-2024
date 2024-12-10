package view.buttons;

import controller.buttonHandlers.HandlerPlay;
import controller.buttonHandlers.HandlerQuit;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MainMenuButtonContainer extends HBox {
    public MainMenuButtonContainer(TextField playerName, Label errorLabel) {
        super(12);
        this.setId("menu-button-container");
        this.setAlignment(Pos.CENTER);

        Button playButton = new ButtonBlue("Nueva Partida");  //Nuevo Juego
        playButton.setOnAction(new HandlerPlay(playerName, errorLabel));

        Button quitButton = new ButtonRed("Salir");
        quitButton.setOnAction(new HandlerQuit());

        this.getChildren().add(playButton);
        this.getChildren().add(quitButton);
    }
}
