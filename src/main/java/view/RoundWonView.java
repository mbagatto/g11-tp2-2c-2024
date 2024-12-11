package view;

import controller.buttonHandlers.HandlerNewRound;
import controller.buttonHandlers.HandlerQuit;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.buttons.ButtonRed;
import view.buttons.ButtonYellow;

public class RoundWonView extends VBox {
    public RoundWonView(Stage stage) {
        super();
        this.setStyle("-fx-background-color: rgba(0,0,0,0.9);");
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPrefSize(1920, 1080);

        Label title = new Label("¡Felicitaciones! Has ganado la ronda.");
        title.setStyle("-fx-text-fill: rgb(121,187,63); -fx-font-size: 92px;");

        Button startAgainButton = new ButtonYellow("Siguiente Ronda");
        startAgainButton.setOnAction(new HandlerNewRound(stage));

        Button quitButton = new ButtonRed("Salir");
        quitButton.setPrefHeight(75);
        quitButton.setOnAction(new HandlerQuit());

        this.getChildren().addAll(title, startAgainButton, quitButton);
    }
}
