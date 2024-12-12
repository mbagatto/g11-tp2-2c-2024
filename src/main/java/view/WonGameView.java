package view;

import controller.SoundPlayer;
import controller.buttonHandlers.HandlerQuit;
import controller.buttonHandlers.HandlerStartAgain;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.buttons.ButtonRed;
import view.buttons.ButtonYellow;

public class WonGameView extends VBox {
    public WonGameView(Stage stage) {
        super();
        this.setStyle("-fx-background-color: rgba(0,0,0,0.9);");
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPrefSize(1920, 1080);
        SoundPlayer soundPlayer = SoundPlayer.getInstance();
        soundPlayer.pauseBackgroundMusic();
        soundPlayer.playWinSound();

        Label title = new Label("¡Felicitaciones! Has ganado el juego.");
        title.setStyle("-fx-text-fill: rgb(255, 235, 167); -fx-font-size: 108px;");

        Button startAgainButton = new ButtonYellow("Volver a empezar");
        startAgainButton.setOnAction(new HandlerStartAgain(stage));

        Button quitButton = new ButtonRed("Salir");
        quitButton.setPrefHeight(75);
        quitButton.setOnAction(new HandlerQuit());

        this.getChildren().addAll(title, startAgainButton, quitButton);
    }
}
