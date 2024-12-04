package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;

public class WinRoundView extends VBox {
    private Stage stage;
    private Round round;
    private Player player;
    private Game game;

    public WinRoundView(Stage stage, Player player, Round actualRound, Game game){
        this.stage = stage;
        this.round = actualRound;
        this.player = player;
        this.game = game;

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(1920, 1080);

        VBox popUp = new VBox(10);
        popUp.setStyle("-fx-background-color: #32CD327F; -fx-border-color: black; -fx-padding: 15; -fx-border-radius: 10; -fx-background-radius: 10;");
        popUp.setAlignment(Pos.CENTER);
        popUp.setPrefWidth(1920);
        popUp.setPrefHeight(1080);

        Label message = new Label("¡Felicidades! Has ganado la ronda.");
        message.setStyle("-fx-font-size: 25; -fx-font-weight: bold;");

        Label nextAction = new Label("El juego se cerrara en instantes..");
        message.setStyle("-fx-font-style: italic; -fx-font-size: 25; -fx-font-weight: bold;");

        Button closeButton = new Button("Cerrar");
        closeButton.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        closeButton.setOnAction(event -> this.getChildren().remove(this.lookup("#popupContainer")));

        popUp.getChildren().addAll(message, nextAction, closeButton);

        VBox popUpContainer = new VBox(popUp);
        popUpContainer.setAlignment(Pos.CENTER);
        popUpContainer.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        popUpContainer.setId("popupContainer");

        popUp.setMaxWidth(360);
        popUp.setMaxHeight(190);

        this.getChildren().add(popUpContainer);
    }

}
