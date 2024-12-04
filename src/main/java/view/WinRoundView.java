package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
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
        this.round = round;
        this.player = player;
        this.game = game;



        // Crear un contenedor para el pop-up con tamaño fijo
        VBox popUp = new VBox(10);
        popUp.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 15; -fx-border-radius: 10; -fx-background-radius: 10;");
        popUp.setAlignment(Pos.CENTER);
        popUp.setPrefWidth(1920);
        popUp.setPrefHeight(1080);

        // Contenido del pop-up
        Label message = new Label("¡Felicidades! Has ganado la ronda.");
        message.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");

        Button closeButton = new Button("Cerrar");
        closeButton.setOnAction(event -> this.getChildren().remove(this.lookup("#popupContainer")));

        popUp.getChildren().addAll(message, closeButton);

        // Crear un contenedor para centrar y dar fondo
        VBox popUpContainer = new VBox(popUp);
        popUpContainer.setAlignment(Pos.CENTER); // Centrar el pop-up
        popUpContainer.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);"); // Fondo semitransparente
        popUpContainer.setId("popupContainer");
        popUpContainer.setPrefSize(this.getWidth(), this.getHeight()); // Asegurar que cubra el tamaño de la escena principal

        // Ajustar manualmente el tamaño
        popUp.setMaxWidth(300);
        popUp.setMaxHeight(150);

        // Añadir el contenedor del pop-up al contenedor principal
        this.getChildren().add(popUpContainer);
    }

}
