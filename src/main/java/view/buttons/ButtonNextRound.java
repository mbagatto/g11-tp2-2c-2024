package view.buttons;

import controller.buttonHandlers.HandlerNextRound;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;

public class ButtonNextRound extends Button {

    private final String initialState = "-fx-background-color: #FF453F; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #FF453F; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;";

    private final String hoverState = "-fx-background-color: #6e0300; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #6e0300; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;";

    public ButtonNextRound(Stage stage, Player player, Round round, Game game) {
        super("Next Round");
        this.setId("button-next-round"); // Esto capaz se puede sacar
        this.setPrefWidth(280);
        this.setPrefHeight(95);
        this.setStyle(initialState);
        this.setOnMouseEntered(e -> this.setStyle(this.hoverState));
        this.setOnMouseExited(e -> this.setStyle(this.initialState));
        this.setOnAction(new HandlerNextRound(stage,player,round,game));
    }
}
