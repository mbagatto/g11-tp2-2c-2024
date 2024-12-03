package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Observer;
import model.Player;
import model.game.Round;
import model.jokers.Joker;
import model.tarots.Tarot;

import java.util.ArrayList;

public class PreparationView extends VBox implements Observer {
    private Stage stage;
    private Round round;
    private Player player;

    public PreparationView(Stage stage, Round round, Player player) {
        this.stage = stage;
        this.round = round;
        this.player = player;
        round.addObserver(this);
        player.addObserver(this);
        this.update();
    }

    @Override
    public void update() {
        stage.setTitle("Balatro - Preparation");

        Image background = new Image("file:src/resources/textures/game_background.jpg");
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundView);

        Pane itemsContainer = new Pane();

        Rectangle leftRectangle = new Rectangle();
        leftRectangle.setX(50);
        leftRectangle.setY(0);
        leftRectangle.setWidth(400);
        leftRectangle.setHeight(1080);
        leftRectangle.setFill(Color.web("#3B3B3BFF", 0.5));
        leftRectangle.setStroke(Color.web("#2B2522FF"));
        leftRectangle.setStrokeWidth(3);

        VBox titleContainer = new VBox();
        titleContainer.setLayoutX(62);
        titleContainer.setLayoutY(100);
        titleContainer.setMinWidth(375);
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setSpacing(2);
        titleContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                        + "-fx-background-radius: 15px;"
                        + "-fx-border-color: rgb(43,37,34);"
                        + "-fx-border-radius: 10px;"
                        + "-fx-border-width: 5px;"
                        + "-fx-padding: 5px;"
        );

        Label title = new Label("SHOP");
        title.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 100px;"
        );

        Label subtitle = new Label("Prepare for the next round!");
        subtitle.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 30px;"
        );

        titleContainer.getChildren().addAll(title, subtitle);

        HBox roundScoreContainer = new HBox();
        roundScoreContainer.setLayoutX(62);
        roundScoreContainer.setLayoutY(425);
        roundScoreContainer.setMinWidth(375);
        roundScoreContainer.setAlignment(Pos.CENTER);
        roundScoreContainer.setSpacing(25);
        roundScoreContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                        + "-fx-background-radius: 12px;"
                        + "-fx-padding: 4px;"
        );

        Label roundScoreTitle = new Label("Round Score");
        roundScoreTitle.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 30px;"
        );

        Label roundScoreValue = new Label("0");
        roundScoreValue.setMinWidth(190);
        roundScoreValue.setAlignment(Pos.CENTER);
        roundScoreValue.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 50px;"
                        + "-fx-background-color: rgba(70,70,70,0.3);"
                        + "-fx-background-radius: 10px;"
        );

        roundScoreContainer.getChildren().addAll(roundScoreTitle, roundScoreValue);

        HBox playsContainer = new HBox();
        playsContainer.setLayoutX(62);
        playsContainer.setLayoutY(500);
        playsContainer.setMinWidth(375);
        playsContainer.setMinHeight(200);
        playsContainer.setAlignment(Pos.BOTTOM_CENTER);
        playsContainer.setSpacing(10);
        playsContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                        + "-fx-background-radius: 12px;"
                        + "-fx-padding: 5px;"
        );

        Label playsPoints = new Label("0");
        playsPoints.setMinWidth(150);
        playsPoints.setAlignment(Pos.CENTER_RIGHT);
        playsPoints.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 80px;"
                        + "-fx-background-color: rgba(0,153,255,0.5);"
                        + "-fx-background-radius: 10px;"
        );

        Label playsSymbol = new Label("X");
        playsSymbol.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 80px;"
        );

        Label playsMult = new Label("0");
        playsMult.setMinWidth(150);
        playsMult.setAlignment(Pos.CENTER_LEFT);
        playsMult.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 80px;"
                        + "-fx-background-color: rgba(251,56,56,0.5);"
                        + "-fx-background-radius: 10px;"
        );

        playsContainer.getChildren().addAll(playsPoints, playsSymbol, playsMult);

        HBox roundInfoContainer = new HBox();
        roundInfoContainer.setLayoutX(145);
        roundInfoContainer.setLayoutY(800);
        roundInfoContainer.setAlignment(Pos.CENTER);
        roundInfoContainer.setSpacing(10);

        VBox roundInfoHandsContainer = new VBox();
        roundInfoHandsContainer.setMinWidth(100);
        roundInfoHandsContainer.setAlignment(Pos.CENTER);
        roundInfoHandsContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                        + "-fx-background-radius: 10px;"
        );

        Label handsContainerTitle = new Label("Hands");
        handsContainerTitle.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 30px;"
        );

        Label handsContainerValue = new Label(round.getHands().toString());
        handsContainerValue.setAlignment(Pos.CENTER);
        handsContainerValue.setMinWidth(90);
        handsContainerValue.setStyle(
                "-fx-font-size: 45px;"
                        + "-fx-background-color: rgba(70,70,70,0.3);"
                        + "-fx-text-fill: rgba(0,153,255,0.5);"
                        + "-fx-background-radius: 10px;"
        );

        roundInfoHandsContainer.getChildren().addAll(handsContainerTitle, handsContainerValue);

        VBox roundInfoDiscardsContainer = new VBox();
        roundInfoDiscardsContainer.setMinWidth(100);
        roundInfoDiscardsContainer.setAlignment(Pos.CENTER);
        roundInfoDiscardsContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                        + "-fx-background-radius: 10px;"
        );

        Label discardsContainerTitle = new Label("Discards");
        discardsContainerTitle.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 30px;"
        );

        Label discardsContainerValue = new Label(round.getDiscards().toString());
        discardsContainerValue.setAlignment(Pos.CENTER);
        discardsContainerValue.setMinWidth(90);
        discardsContainerValue.setStyle(
                "-fx-font-size: 45px;"
                        + "-fx-background-color: rgba(70,70,70,0.3);"
                        + "-fx-text-fill: rgba(251,56,56,0.5);"
                        + "-fx-background-radius: 10px;"
        );

        roundInfoDiscardsContainer.getChildren().addAll(discardsContainerTitle, discardsContainerValue);
        roundInfoContainer.getChildren().addAll(roundInfoHandsContainer, roundInfoDiscardsContainer);

        itemsContainer.getChildren().add(leftRectangle);
        itemsContainer.getChildren().add(titleContainer);
        itemsContainer.getChildren().add(roundScoreContainer);
        itemsContainer.getChildren().add(playsContainer);
        itemsContainer.getChildren().add(roundInfoContainer);

        ArrayList<Joker> jokers = this.round.getStore().getJokers();
        ArrayList<Tarot> tarots = this.round.getStore().getTarots();

        VBox playerJokers = new PlayerJokersContainer(player);
        VBox playerTarots = new PlayerTarotsContainer(player);

        itemsContainer.getChildren().add(playerJokers);
        itemsContainer.getChildren().add(playerTarots);

        itemsContainer.getChildren().add(new ShopContainer(stage, playerJokers, playerTarots, jokers, tarots, player));

        backgroundContainer.getChildren().add(itemsContainer);

        this.getChildren().addAll(backgroundContainer);
    }
}
