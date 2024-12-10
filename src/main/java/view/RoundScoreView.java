package view;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RoundScoreView extends VBox {
    public RoundScoreView(String scoreToBeat) {
        super();
        this.setId("round-score-pane");
        this.setAlignment(Pos.CENTER);
        this.setLayoutX(150);
        this.setLayoutY(65);
        this.setPrefHeight(130);
        this.setPrefWidth(210);

        Label scoreInstructionLabel = new Label("Anota al menos");
        scoreInstructionLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: white;");

        HBox scoreInstructionBox = new HBox();
        scoreInstructionBox.setAlignment(Pos.CENTER);
        scoreInstructionBox.setSpacing(10);

        ColorAdjust colorAdjustBrightness = new ColorAdjust();
        colorAdjustBrightness.setBrightness(-0.3);

        ColorAdjust colorAdjustSaturation = new ColorAdjust();
        colorAdjustSaturation.setSaturation(1);

        Image chipsImage = new Image("file:src/resources/textures/chips.png");
        double x = 60;
        double y = 0;
        double width = 55;
        double height = 55;

        ImageView chipImageView = new ImageView(chipsImage);
        chipImageView.setViewport(new Rectangle2D(x, y, width, height));
        chipImageView.setFitWidth(35);
        chipImageView.setFitHeight(35);
        chipImageView.setEffect(colorAdjustSaturation);
        chipImageView.setEffect(colorAdjustBrightness);

        Label scoreValue = new Label(scoreToBeat);
        scoreValue.setStyle("-fx-font-size: 45px; -fx-text-fill: rgb(255, 235, 167);");
        scoreValue.setPrefHeight(60);

        scoreInstructionBox.getChildren().addAll(chipImageView, scoreValue);

        this.getChildren().add(scoreInstructionLabel);
        this.getChildren().add(scoreInstructionBox);
    }
}
