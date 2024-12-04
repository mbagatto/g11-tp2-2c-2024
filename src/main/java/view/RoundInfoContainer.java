package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.game.Round;

public class RoundInfoContainer extends HBox {
    public RoundInfoContainer(Round round) {
        super();
        this.setLayoutX(145);
        this.setLayoutY(800);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

        VBox roundInfoHandsContainer = new VBox();
        roundInfoHandsContainer.setPrefWidth(125);
        roundInfoHandsContainer.setPrefHeight(100);
        roundInfoHandsContainer.setAlignment(Pos.CENTER);
        roundInfoHandsContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.5);"
                + "-fx-background-radius: 10px;"
        );

        Label handsContainerTitle = new Label("Manos");
        handsContainerTitle.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 30px;"
        );

        Label handsValueContainer = new Label(round.getHands().toString());
        handsValueContainer.setId("hands-value-container");
        handsValueContainer.setAlignment(Pos.CENTER);
        handsValueContainer.setMinWidth(90);

        roundInfoHandsContainer.getChildren().addAll(handsContainerTitle, handsValueContainer);

        VBox roundInfoDiscardsContainer = new VBox();
        roundInfoDiscardsContainer.setPrefWidth(125);
        roundInfoDiscardsContainer.setPrefHeight(100);
        roundInfoDiscardsContainer.setAlignment(Pos.CENTER);
        roundInfoDiscardsContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                + "-fx-background-radius: 10px;"
        );

        Label discardsContainerTitle = new Label("Descartes");
        discardsContainerTitle.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                + "-fx-font-size: 30px;"
        );

        Label discardsValueContainer = new Label(round.getDiscards().toString());
        discardsValueContainer.setId("discards-value-container");
        discardsValueContainer.setAlignment(Pos.CENTER);
        discardsValueContainer.setMinWidth(90);

        roundInfoDiscardsContainer.getChildren().addAll(discardsContainerTitle, discardsValueContainer);

        this.getChildren().add(roundInfoHandsContainer);
        this.getChildren().add(roundInfoDiscardsContainer);
    }
}
