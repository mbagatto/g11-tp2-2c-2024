package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ActualScoreView extends Pane {
    public ActualScoreView(String actualScore) {
        super();
        this.setId("actual-score-pane");
        this.setLayoutX(60);
        this.setLayoutY(385);
        this.setPrefHeight(100);
        this.setPrefWidth(375);

        Image chipsImage = new Image("file:src/resources/textures/chips.png");
        ColorAdjust colorAdjustBrightness = new ColorAdjust();
        colorAdjustBrightness.setBrightness(-0.3);

        ColorAdjust colorAdjustSaturation = new ColorAdjust();
        colorAdjustSaturation.setSaturation(1);

        ImageView chipsImageView = new ImageView(chipsImage);
        chipsImageView.setViewport(new javafx.geometry.Rectangle2D(60, 0, 55, 55));
        chipsImageView.setFitWidth(35);
        chipsImageView.setFitHeight(35);
        chipsImageView.setEffect(colorAdjustSaturation);
        chipsImageView.setEffect(colorAdjustBrightness);

        VBox vboxScoreLabel = new VBox();
        vboxScoreLabel.setAlignment(Pos.CENTER);
        vboxScoreLabel.setPrefHeight(50);

        Label wordRound = new Label("Ronda");
        wordRound.setStyle("-fx-font-size: 40px; -fx-text-fill: white;");

        Label punctuation = new Label("puntuacion");
        punctuation.setStyle("-fx-font-size: 30px; -fx-text-fill: white;");

        vboxScoreLabel.getChildren().addAll(wordRound, punctuation);

        HBox hboxActualScore = new HBox(10);
        hboxActualScore.setAlignment(Pos.CENTER);
        hboxActualScore.setLayoutX(10);
        hboxActualScore.setLayoutY(15);
        hboxActualScore.setPrefWidth(375);

        HBox hboxActualScoreChip = new HBox(5);
        hboxActualScoreChip.setId("actual-score-chip");
        hboxActualScoreChip.setAlignment(Pos.CENTER);
        hboxActualScoreChip.setPrefWidth(200);
        hboxActualScoreChip.setPrefHeight(50);
        hboxActualScoreChip.setPadding(new Insets(0, 0, 0, 0));

        Label actualScoreLabel = new Label(actualScore);
        actualScoreLabel.setStyle("-fx-font-size: 45px; -fx-text-fill: white;");

        hboxActualScoreChip.getChildren().addAll(chipsImageView, actualScoreLabel);

        hboxActualScore.getChildren().addAll(vboxScoreLabel, hboxActualScoreChip);

        this.getChildren().add(hboxActualScore);
    }
}
