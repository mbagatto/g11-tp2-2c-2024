package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HandlerNextRound  implements EventHandler<ActionEvent> {
    private Stage stage;

    public HandlerNextRound(Stage stage) {
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent) {
        Image staticBackground = new Image("file:src/resources/textures/static_game_background.png");
        ImageView backgroundView = new ImageView(staticBackground);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundView);

        Pane itemsContainer = new Pane();

        Rectangle rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(0);
        rectangle.setWidth(400);
        rectangle.setHeight(1080);
        rectangle.setFill(Color.web("#212829"));
        rectangle.setStroke(Color.web("#004A7B"));
        rectangle.setStrokeWidth(3);

        HBox roundTitleFrame = new HBox();
        roundTitleFrame.setAlignment(Pos.CENTER);
        roundTitleFrame.setStyle(
                "-fx-background-color: #004A7B; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-padding: 9px; " +
                        "-fx-border-color: #004A7B; " +
                        "-fx-border-radius: 25px; " +
                        "-fx-border-width: 1px;"
        );

        roundTitleFrame.setLayoutX(60);
        roundTitleFrame.setLayoutY(20);
        roundTitleFrame.setPrefHeight(100);
        roundTitleFrame.setPrefWidth(380);

        Label roundLabel = new Label("Ronda 1"); // Deberia ir el numero de ronda actual
        roundLabel.setStyle("-fx-font-size: 40px; -fx-text-fill: white; -fx-font-weight: 900;");

        roundTitleFrame.getChildren().add(roundLabel);

        Pane roundInfo = new Pane();
        roundInfo.setLayoutX(60);
        roundInfo.setLayoutY(135);
        roundInfo.setPrefHeight(240);
        roundInfo.setPrefWidth(380);
        roundInfo.setStyle(
                "-fx-background-color: #0B2F47; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-border-color: #0B2F47; " +
                        "-fx-border-width: 1px; " +
                        "-fx-border-radius: 25px;"
        );

        Image whiteCoin = new Image("file:src/resources/textures/white_coin.png");
        ImageView whiteCoinView = new ImageView(whiteCoin);
        whiteCoinView.setFitWidth(130);
        whiteCoinView.setFitHeight(130);
        whiteCoinView.setLayoutX(10);
        whiteCoinView.setLayoutY(65);

        Pane roundScore = new Pane();
        roundScore.setLayoutX(150);
        roundScore.setLayoutY(65);
        roundScore.setPrefHeight(130);
        roundScore.setPrefWidth(210);
        roundScore.setStyle(
                "-fx-background-color: #161D1E; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-border-color: #161D1E; " +
                        "-fx-border-width: 1px; " +
                        "-fx-border-radius: 25px;"
        );

        Label scoreInstructionLabel = new Label("Anota al menos");
        scoreInstructionLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");

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
        chipImageView.setViewport(new javafx.geometry.Rectangle2D(x, y, width, height));
        chipImageView.setFitWidth(35);
        chipImageView.setFitHeight(35);
        chipImageView.setEffect(colorAdjustSaturation);
        chipImageView.setEffect(colorAdjustBrightness);


        ImageView chipImageView2 = new ImageView(chipsImage);
        chipImageView2.setViewport(new javafx.geometry.Rectangle2D(x, y, width, height));
        chipImageView2.setFitWidth(35);
        chipImageView2.setFitHeight(35);
        chipImageView2.setEffect(colorAdjustSaturation);
        chipImageView2.setEffect(colorAdjustBrightness);


        VBox scoreInstructionBox = new VBox(-5);
        scoreInstructionBox.setAlignment(Pos.CENTER);
        scoreInstructionBox.setLayoutX(0);
        scoreInstructionBox.setLayoutY(10);
        scoreInstructionBox.setPrefWidth(roundScore.getPrefWidth());

        Label score = new Label("3000"); // Aca va el score necesario para ganar la ronda
        score.setStyle("-fx-font-size: 45px; -fx-text-fill: #C03933; -fx-font-weight: bold;");
        score.setPrefHeight(60);

        HBox scoreBox = new HBox(5);
        scoreBox.setAlignment(Pos.CENTER);

        scoreBox.getChildren().addAll(chipImageView, score);

        Label reward = new Label("Sin recompensa"); // Aca va la cantidad de dinero que hay de recompensa
        reward.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");

        scoreInstructionBox.getChildren().addAll(scoreInstructionLabel, scoreBox, reward);

        roundScore.getChildren().addAll(scoreInstructionBox);

        roundInfo.getChildren().addAll(whiteCoinView, roundScore);

        Pane actualScoreInfo = new Pane();
        actualScoreInfo.setLayoutX(60);
        actualScoreInfo.setLayoutY(385);
        actualScoreInfo.setPrefHeight(100);
        actualScoreInfo.setPrefWidth(380);
        actualScoreInfo.setStyle(
                "-fx-background-color: #111D1C; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-border-color: #111D1C; " +
                        "-fx-border-width: 1px; " +
                        "-fx-border-radius: 25px;"
        );

        VBox vboxScoreLabel = new VBox(-10);
        vboxScoreLabel.setAlignment(Pos.CENTER);
        vboxScoreLabel.setPrefHeight(50); // Ajusta a un valor más pequeño

        Label wordRound = new Label("Ronda");
        wordRound.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-weight: bold;");

        Label puntuation = new Label("puntuacion");
        puntuation.setStyle("-fx-font-size: 15px; -fx-text-fill: white; -fx-font-weight: bold;");

        vboxScoreLabel.getChildren().addAll(wordRound, puntuation);
        vboxScoreLabel.setMargin(wordRound, new Insets(0, 0, 0, 0));
        vboxScoreLabel.setMargin(puntuation, new Insets(0, 0, 0, 0));

        HBox hboxActualScore = new HBox(20);
        hboxActualScore.setAlignment(Pos.CENTER);
        hboxActualScore.setLayoutX(10);
        hboxActualScore.setLayoutY(10);
        hboxActualScore.setPrefWidth(380);

        HBox hboxActualScoreChip = new HBox(20);
        hboxActualScoreChip.setAlignment(Pos.CENTER);
        hboxActualScoreChip.setStyle(
                "-fx-background-color: #212829; " + //212829
                        "-fx-background-radius: 17px; " +
                        "-fx-padding: 5px; " +
                        "-fx-border-color: #212829; " +
                        "-fx-border-radius: 17px; " +
                        "-fx-border-width: 1px;"
        );
        hboxActualScoreChip.setPrefWidth(240);
        hboxActualScoreChip.setPrefHeight(50);
        hboxActualScoreChip.setPadding(new Insets(0, 0, 0, 0));

        Label actualScore = new Label("0");
        actualScore.setStyle("-fx-font-size: 45px; -fx-text-fill: #C0C6C6; -fx-font-weight: bold;");

        hboxActualScoreChip.getChildren().addAll(chipImageView2, actualScore);

        hboxActualScore.getChildren().addAll(vboxScoreLabel, hboxActualScoreChip);

        actualScoreInfo.getChildren().addAll(hboxActualScore);

        itemsContainer.getChildren().addAll(rectangle, roundTitleFrame, roundInfo, actualScoreInfo);

        backgroundContainer.getChildren().add(itemsContainer);

        Scene gameScene = new Scene(backgroundContainer, 1920, 1080);

        this.stage.setMaximized(true);
        this.stage.setScene(gameScene);
        this.stage.show();
    }
}
