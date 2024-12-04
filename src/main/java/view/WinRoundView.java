package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;
import view.buttons.ButtonNextGame;

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

        this.round = this.game.nextRound();

        if (this.round == null) {
            FinalWinScreenView finalScreen = new FinalWinScreenView(this.stage); // Esto lleva a la pantalla final porque no quedna mas rondas
        }

        VBox popUp = new VBox(10);
        popUp.setStyle("-fx-background-color: #32CD327F; -fx-border-color: black; -fx-padding: 15; -fx-border-radius: 10; -fx-background-radius: 10;");
        popUp.setAlignment(Pos.CENTER);
        popUp.setPrefWidth(1920);
        popUp.setPrefHeight(1080);

        Label message = new Label("¡Felicidades! Has ganado la ronda.");
        message.setStyle("-fx-font-size: 25; -fx-font-weight: bold;");

        Label nextAction = new Label("Presiona el boton para avanzar a la siguiente Ronda !");
        message.setStyle("-fx-font-style: italic; -fx-font-size: 25; -fx-font-weight: bold;");

        //Button nextRound = new ButtonNextRound(this.stage, this.player, this.round, this.game); // Este boton hace que cuando termine una ronda pase a la siguiente de una
        Button nextRound = new ButtonNextGame(this.stage, this.player, this.round, this.game); // Este boton hace que aparezca la tienda antes de cada ronda
        popUp.getChildren().addAll(message, nextAction, nextRound);

        VBox popUpContainer = new VBox(popUp);
        popUpContainer.setAlignment(Pos.CENTER);
        popUpContainer.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        popUpContainer.setId("popupContainer");

        popUp.setMaxWidth(360);
        popUp.setMaxHeight(190);

        this.getChildren().add(popUpContainer);
    }
}
