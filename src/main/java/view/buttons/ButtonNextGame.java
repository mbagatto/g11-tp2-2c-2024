package view.buttons;

import controller.buttonHandlers.HandlerNextGame;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;

public class ButtonNextGame extends Button {

    private final String initialState = "-fx-background-color: #14f200; " +
            "-fx-text-fill: black; " +
            "-fx-font-size: 25px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #14F200FF; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;";

    private final String hoverState = "-fx-background-color: #0f7200; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 25px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #0f7200; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;";

    public ButtonNextGame(Stage stage, Player player, Round round, Game game) {
        super("Siguiente Juego");
        this.setId("button-next-game");
        this.setPrefWidth(350);
        this.setPrefHeight(80);
        this.setStyle(this.initialState);
        this.setOnMouseEntered(e -> this.setStyle(hoverState));
        this.setOnMouseExited(e -> this.setStyle(initialState));
        this.setOnAction(new HandlerNextGame(stage, player, round, game));
    }
}
