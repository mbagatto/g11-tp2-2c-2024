package view;

import controller.buttonHandlers.HandlerAddJoker;
import controller.buttonHandlers.HandlerAddTarot;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import java.util.Collections;

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

        Image staticBackground = new Image("file:src/resources/textures/game_background.jpg");
        ImageView backgroundView = new ImageView(staticBackground);
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

        HBox jokersContainer = new HBox();
        jokersContainer.setMinWidth(750);
        jokersContainer.setMinHeight(150);
        jokersContainer.setLayoutX(500);
        jokersContainer.setLayoutY(75);
        jokersContainer.setSpacing(15);
        jokersContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                + "-fx-background-radius: 10px;"
                + "-fx-padding: 15px;"
        );

        for (Joker joker : this.player.getJokers()) {
            VBox jokerContainer = new VBox();
            jokerContainer.setAlignment(Pos.CENTER);

            Label jokerName = new Label(joker.getName());
            jokerName.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                    + "-fx-font-size: 16px;"
            );

            Image jokerImage = new Image("file:src/resources/textures/jokerImage.png");
            ImageView jokerImageView = new ImageView(jokerImage);
            jokerImageView.setFitHeight(100);
            jokerImageView.setFitWidth(75);

            Label jokerDescription = new Label(joker.getDescription());
            jokerDescription.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                            + "-fx-font-size: 16px;"
            );

            jokerContainer.getChildren().addAll(jokerName, jokerImageView, jokerDescription);

            jokersContainer.getChildren().add(jokerContainer);
        }

        Label jokersAmount = new Label(this.player.getJokersSize() + "/5");
        jokersAmount.setLayoutX(505);
        jokersAmount.setLayoutY(230);
        jokersAmount.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                + "-fx-font-size: 20px;"
        );

        HBox tarotsContainer = new HBox();
        tarotsContainer.setMinWidth(300);
        tarotsContainer.setMinHeight(150);
        tarotsContainer.setLayoutX(1300);
        tarotsContainer.setLayoutY(75);
        tarotsContainer.setSpacing(15);
        tarotsContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                + "-fx-background-radius: 10px;"
                + "-fx-padding: 15px;"
        );

        for (Tarot tarot : this.player.getTarots()) {
            VBox tarotContainer = new VBox();
            tarotContainer.setAlignment(Pos.CENTER);

            Label tarotName = new Label(tarot.getName());
            tarotName.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                    + "-fx-font-size: 16px;"
            );

            Image tarotImage = new Image("file:src/resources/textures/tarotImage.png");
            ImageView tarotImageView = new ImageView(tarotImage);
            tarotImageView.setFitHeight(100);
            tarotImageView.setFitWidth(75);

            Label tarotDescription = new Label(tarot.getDescription());
            tarotDescription.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                            + "-fx-font-size: 16px;"
            );

            tarotContainer.getChildren().addAll(tarotName, tarotImageView, tarotDescription);

            tarotsContainer.getChildren().add(tarotContainer);
        }

        Label tarotsAmount = new Label(this.player.getTarotsSize() + "/2");
        tarotsAmount.setLayoutX(1305);
        tarotsAmount.setLayoutY(230);
        tarotsAmount.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                + "-fx-font-size: 20px;"
        );

        VBox shopContainer = new VBox();
        shopContainer.setAlignment(Pos.TOP_CENTER);
        shopContainer.setLayoutX(550);
        shopContainer.setLayoutY(375);
        shopContainer.setMinWidth(850);
        shopContainer.setMinHeight(750);
        shopContainer.setSpacing(10);
        shopContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                + "-fx-background-radius: 15px;"
                + "-fx-border-color: rgb(43,37,34);"
                + "-fx-border-radius: 10px;"
                + "-fx-border-width: 5px;"
                + "-fx-padding: 5px;"
        );

        Button nextRoundButton = new Button("Next Round"); // falta setOnAction
        nextRoundButton.setStyle(
                "-fx-font-size: 45px;"
                + "-fx-background-color: rgba(251,56,56,0.5);"
                + "-fx-text-fill: rgba(255,255,255,0.97);"
                + "-fx-background-radius: 10px;"
                + "-fx-cursor: hand;"
        );

        ArrayList<HBox> products = new ArrayList<>();

        for (Joker joker : this.round.getStore().getJokers()) {
            HBox jokerContainer = new HBox();
            jokerContainer.setAlignment(Pos.CENTER);
            jokerContainer.setSpacing(10);
            jokerContainer.setStyle(
                    "-fx-background-color: rgba(70,70,70,0.3);"
                    + "-fx-background-radius: 10px;"
                    + "-fx-padding: 5px;"
            );

            VBox jokerNameAndImage =  new VBox();
            jokerNameAndImage.setAlignment(Pos.CENTER);

            Label jokerName = new Label(joker.getName());
            jokerName.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                            + "-fx-font-size: 16px;"
            );

            Image jokerImage = new Image("file:src/resources/textures/jokerImage.png");
            ImageView jokerImageView = new ImageView(jokerImage);
            jokerImageView.setFitHeight(100);
            jokerImageView.setFitWidth(75);

            jokerNameAndImage.getChildren().addAll(jokerName, jokerImageView);

            Label jokerDescription = new Label(joker.getDescription());
            jokerDescription.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                            + "-fx-font-size: 16px;"
            );

            Button addButton = new ButtonAdd();
            addButton.setOnAction(new HandlerAddJoker(this.player, joker, shopContainer, jokerContainer));

            jokerContainer.getChildren().addAll(jokerNameAndImage, jokerDescription, addButton);

            products.add(jokerContainer);
        }

        for (Tarot tarot : this.round.getStore().getTarots()) {
            HBox tarotContainer = new HBox();
            tarotContainer.setAlignment(Pos.CENTER);
            tarotContainer.setSpacing(10);
            tarotContainer.setStyle(
                    "-fx-background-color: rgba(70,70,70,0.3);"
                    + "-fx-background-radius: 10px;"
                    + "-fx-padding: 5px;"
            );

            VBox tarotNameAndImage =  new VBox();
            tarotNameAndImage.setAlignment(Pos.CENTER);

            Label tarotName = new Label(tarot.getName());
            tarotName.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                            + "-fx-font-size: 16px;"
            );

            Image tarotImage = new Image("file:src/resources/textures/tarotImage.png");
            ImageView tarotImageView = new ImageView(tarotImage);
            tarotImageView.setFitHeight(100);
            tarotImageView.setFitWidth(75);

            tarotNameAndImage.getChildren().addAll(tarotName, tarotImageView);

            Label tarotDescription = new Label(tarot.getDescription());
            tarotDescription.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                            + "-fx-font-size: 16px;"
            );

            Button addButton = new ButtonAdd();
            addButton.setOnAction(new HandlerAddTarot(this.player, tarot, shopContainer, tarotContainer));

            tarotContainer.getChildren().addAll(tarotNameAndImage, tarotDescription, addButton);

            products.add(tarotContainer);
        }

        Collections.shuffle(products);

        shopContainer.getChildren().add(nextRoundButton);
        shopContainer.getChildren().add(products.getFirst());
        shopContainer.getChildren().add(products.get(1));
        shopContainer.getChildren().add(products.get(2));
        shopContainer.getChildren().add(products.get(3));

        itemsContainer.getChildren().add(leftRectangle);
        itemsContainer.getChildren().add(titleContainer);
        itemsContainer.getChildren().add(roundScoreContainer);
        itemsContainer.getChildren().add(playsContainer);
        itemsContainer.getChildren().add(roundInfoContainer);
        itemsContainer.getChildren().add(jokersContainer);
        itemsContainer.getChildren().add(jokersAmount);
        itemsContainer.getChildren().add(tarotsContainer);
        itemsContainer.getChildren().add(tarotsAmount);
        itemsContainer.getChildren().add(shopContainer);
        ButtonNextRound nextRoundButton = new ButtonNextRound(this.stage); // boton para pasar a la siguiente ronda

        itemsContainer.getChildren().addAll(rectangle, titleContainer, roundScoreContainer, playsContainer, roundInfoContainer, jokersContainer, nextRoundButton);

        backgroundContainer.getChildren().add(itemsContainer);

        this.getChildren().addAll(backgroundContainer);
    }
}
