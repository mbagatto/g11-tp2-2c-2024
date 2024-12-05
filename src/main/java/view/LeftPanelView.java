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
import model.game.Round;

public class LeftPanelView extends VBox {
    public LeftPanelView(Round round) {
        super();
        this.setLayoutX(62);
        this.setLayoutY(350);
        this.setMinWidth(350);
        this.setSpacing(50);
        this.setId("shop-round-score-container");

        Image chipsImage = new Image("file:src/resources/textures/chips.png");
        double x = 60;
        double y = 0;
        double width = 55;
        double height = 55;

        ColorAdjust colorAdjustBrightness = new ColorAdjust();
        colorAdjustBrightness.setBrightness(-0.3);

        ColorAdjust colorAdjustSaturation = new ColorAdjust();
        colorAdjustSaturation.setSaturation(1);

        ImageView chipImageView2 = new ImageView(chipsImage);
        chipImageView2.setViewport(new javafx.geometry.Rectangle2D(x, y, width, height));
        chipImageView2.setFitWidth(35);
        chipImageView2.setFitHeight(35);
        chipImageView2.setEffect(colorAdjustSaturation);
        chipImageView2.setEffect(colorAdjustBrightness);

        Pane actualScoreInfo = new Pane();
        actualScoreInfo.setId("actual-score-pane");
        actualScoreInfo.setLayoutX(60);
        actualScoreInfo.setLayoutY(385);
        actualScoreInfo.setPrefHeight(100);
        actualScoreInfo.setPrefWidth(375);

        VBox vboxScoreLabel = new VBox();
        vboxScoreLabel.setAlignment(Pos.CENTER);
        vboxScoreLabel.setPrefHeight(50);

        Label wordRound = new Label("Ronda");
        wordRound.setStyle("-fx-font-size: 40px; -fx-text-fill: white;");

        Label puntuation = new Label("puntuacion");
        puntuation.setStyle("-fx-font-size: 30px; -fx-text-fill: white;");

        vboxScoreLabel.getChildren().addAll(wordRound, puntuation);
        vboxScoreLabel.setMargin(wordRound, new Insets(0, 0, 0, 0));
        vboxScoreLabel.setMargin(puntuation, new Insets(0, 0, 0, 0));

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

        Label actualScore = new Label("0");
        actualScore.setStyle("-fx-font-size: 45px; -fx-text-fill: white;");

        hboxActualScoreChip.getChildren().addAll(chipImageView2, actualScore);

        hboxActualScore.getChildren().addAll(vboxScoreLabel, hboxActualScoreChip);

        actualScoreInfo.getChildren().addAll(hboxActualScore);

        this.getChildren().add(actualScoreInfo);
        this.getChildren().add(new PointsAndMultView());
        this.getChildren().add(new RoundInfoContainer(round));
    }
}
