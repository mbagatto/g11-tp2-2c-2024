package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.*;
import model.game.Game;
import model.game.Round;
import view.buttons.ButtonDiscardHand;
import view.buttons.ButtonPlayHand;
import view.records.*;
import java.util.*;

public class GameView extends StackPane implements ObserverPlayer, ObserverRound, ObserverPlayerDeck {
    private Stage stage;
    private Game game;
    private HashMap<String,HashMap<String,StackPane>> ImageCards;
    private List<String> numbersCards = new ArrayList<>();
    private List<String> suitsCards = new ArrayList<>();
    //player
    private Player player;
    private PlayerObserver playerObserver;
    private List<Integer> selectecCardIndex;
    //round
    private Round actualRound;
    private RoundObserver roundObserver;
    private Label roundLabel;
    private Label score;
    private Label actualScore;
    private Label handsContainerValue;
    private Label discardsContainerValue;
    //hand
    private Label labelHand;
    private Label playsMult;
    private Label playsPoints;

    private HBox cardsContainer;

    private PlayerJokersView playerJokersView;
    private PlayerTarotsView playerTarotsView;

    public GameView(Stage stage, Player player, Round actualRound, Game game, PlayerJokersView playerJokersView, PlayerTarotsView playerTarotsView)  {
        this.selectecCardIndex = new ArrayList<>();
        this.player = player;
        this.player.shuffleDeck();
        this.player.completeDeck();
        this.playerObserver = new PlayerObserver(this.player);
        this.actualRound = actualRound;
        this.stage = stage;
        this.game = game;
        this.playerJokersView = playerJokersView;
        this.playerTarotsView = playerTarotsView;

        this.roundObserver = new RoundObserver(this.actualRound);

        Image staticBackground = new Image("file:src/resources/textures/game_background.jpg");
        ImageView backgroundView = new ImageView(staticBackground);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        this.getChildren().add(backgroundView);

        Pane itemsContainer = new Pane();

        Rectangle leftRectangle = new Rectangle();
        leftRectangle.setX(50);
        leftRectangle.setY(0);
        leftRectangle.setWidth(400);
        leftRectangle.setHeight(1080);
        leftRectangle.setFill(Color.web("#3B3B3B44"));
        leftRectangle.setStroke(Color.web("#FFEBA7FF"));
        leftRectangle.setStrokeWidth(5);

        HBox roundTitleFrame = new HBox();
        roundTitleFrame.setId("round-title-frame");
        roundTitleFrame.setAlignment(Pos.CENTER);
        roundTitleFrame.setLayoutX(60);
        roundTitleFrame.setLayoutY(20);
        roundTitleFrame.setPrefHeight(100);
        roundTitleFrame.setPrefWidth(380);

        this.roundLabel = new Label("Ronda " + actualRound.getNumber());
        roundLabel.setStyle("-fx-font-size: 60px; -fx-text-fill: white;");

        roundTitleFrame.getChildren().add(roundLabel);

        Pane roundInfo = new Pane();
        roundInfo.setId("round-info-pane");
        roundInfo.setLayoutX(60);
        roundInfo.setLayoutY(135);
        roundInfo.setPrefHeight(240);
        roundInfo.setPrefWidth(380);

        Image whiteCoin = new Image("file:src/resources/textures/white_coin.png");
        ImageView whiteCoinView = new ImageView(whiteCoin);
        whiteCoinView.setFitWidth(130);
        whiteCoinView.setFitHeight(130);
        whiteCoinView.setLayoutX(10);
        whiteCoinView.setLayoutY(65);

        Pane roundScore = new Pane();
        roundScore.setId("round-score-pane");
        roundScore.setLayoutX(150);
        roundScore.setLayoutY(65);
        roundScore.setPrefHeight(130);
        roundScore.setPrefWidth(210);

        Label scoreInstructionLabel = new Label("Anota al menos");
        scoreInstructionLabel.setStyle("-fx-font-size: 22px; -fx-text-fill: white;");

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

        this.score = new Label(actualRound.getScoreToBeat().toString()); // Aca va el score necesario para ganar la ronda
        score.setStyle("-fx-font-size: 45px; -fx-text-fill: #C03933;");
        score.setPrefHeight(60);

        HBox scoreBox = new HBox(5);
        scoreBox.setAlignment(Pos.CENTER);

        scoreBox.getChildren().addAll(chipImageView, score);

        Label reward = new Label("Sin recompensa"); // Aca va la cantidad de dinero que hay de recompensa
        reward.setStyle("-fx-font-size: 22px; -fx-text-fill: white;");

        scoreInstructionBox.getChildren().addAll(scoreInstructionLabel, scoreBox, reward);

        roundScore.getChildren().addAll(scoreInstructionBox);

        roundInfo.getChildren().addAll(whiteCoinView, roundScore);

        Pane actualScoreInfo = new Pane();
        actualScoreInfo.setId("actual-score-pane");
        actualScoreInfo.setLayoutX(60);
        actualScoreInfo.setLayoutY(385);
        actualScoreInfo.setPrefHeight(100);
        actualScoreInfo.setPrefWidth(385);

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
        hboxActualScore.setPrefWidth(380);

        HBox hboxActualScoreChip = new HBox(5);
        hboxActualScoreChip.setId("actual-score-chip");
        hboxActualScoreChip.setAlignment(Pos.CENTER);
        hboxActualScoreChip.setPrefWidth(200);
        hboxActualScoreChip.setPrefHeight(50);
        hboxActualScoreChip.setPadding(new Insets(0, 0, 0, 0));

        this.actualScore = new Label(actualRound.getActualScore().toString());
        actualScore.setStyle("-fx-font-size: 45px; -fx-text-fill: white;");

        hboxActualScoreChip.getChildren().addAll(chipImageView2, actualScore);

        hboxActualScore.getChildren().addAll(vboxScoreLabel, hboxActualScoreChip);

        actualScoreInfo.getChildren().addAll(hboxActualScore);

        //Arranca

        VBox playsContainerV = new VBox();
        playsContainerV.setLayoutX(62);
        playsContainerV.setLayoutY(500);
        playsContainerV.setMinWidth(375);
        playsContainerV.setMinHeight(200);

        VBox pointsAndMultView = new PointsAndMultView();
        this.labelHand = (Label) pointsAndMultView.getChildren().getFirst();
        HBox pointsAndMult = (HBox) pointsAndMultView.getChildren().getLast();
        this.playsPoints = (Label) pointsAndMult.getChildren().getFirst();
        this.playsMult = (Label) pointsAndMult.getChildren().getLast();

        playsContainerV.getChildren().add(pointsAndMultView);

        HBox roundInfoContainer = new HBox(10);
        roundInfoContainer.setLayoutX(145);
        roundInfoContainer.setLayoutY(800);
        roundInfoContainer.setAlignment(Pos.CENTER);

        VBox roundInfoHandsContainer = new VBox(5);
        roundInfoHandsContainer.setMinWidth(125);
        roundInfoHandsContainer.setPrefHeight(100);
        roundInfoHandsContainer.setAlignment(Pos.CENTER);
        roundInfoHandsContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                        + "-fx-background-radius: 10px;"
        );

        Label handsContainerTitle = new Label("Manos");
        handsContainerTitle.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 30px;"
        );

        this.handsContainerValue = new Label();
        handsContainerValue.setAlignment(Pos.CENTER);
        handsContainerValue.setMinWidth(90);
        handsContainerValue.setStyle(
                "-fx-font-size: 50px;"
                        + "-fx-background-color: rgba(70,70,70,0.3);"
                        + "-fx-text-fill: rgba(0,153,255,0.5);"
                        + "-fx-background-radius: 15px;"
                        + "-fx-padding: 0 0 5 0px;"
        );

        roundInfoHandsContainer.getChildren().addAll(handsContainerTitle, this.handsContainerValue);

        VBox roundInfoDiscardsContainer = new VBox(5);
        roundInfoDiscardsContainer.setMinWidth(125);
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

        this.discardsContainerValue = new Label();
        discardsContainerValue.setAlignment(Pos.CENTER);
        discardsContainerValue.setMinWidth(90);
        discardsContainerValue.setStyle(
                "-fx-font-size: 50px;"
                        + "-fx-background-color: rgba(70,70,70,0.3);"
                        + "-fx-text-fill: rgba(251,56,56,0.5);"
                        + "-fx-background-radius: 15px;"
                        + "-fx-padding: 0 0 5 0px;"
        );

        roundInfoDiscardsContainer.getChildren().addAll(discardsContainerTitle, discardsContainerValue);
        roundInfoContainer.getChildren().addAll(roundInfoHandsContainer, roundInfoDiscardsContainer);

        // Termina

        itemsContainer.getChildren().addAll(leftRectangle, roundTitleFrame, roundInfo, actualScoreInfo, playsContainerV, roundInfoContainer);

        HBox buttonPlayContainer = new HBox(10);
        buttonPlayContainer.setPrefHeight(200);
        buttonPlayContainer.setLayoutX(800);
        buttonPlayContainer.setLayoutY(950);

        TurnedDeckView turnedDeckView = new TurnedDeckView(player.getEnglishDeck());

        buttonPlayContainer.getChildren().add(new ButtonPlayHand(this.playerObserver,this.roundObserver,this.selectecCardIndex, stage, turnedDeckView));
        buttonPlayContainer.getChildren().add(new ButtonDiscardHand(this.playerObserver,this.roundObserver,this.selectecCardIndex, turnedDeckView));

        this.generateImageCard();

        this.cardsContainer = new HBox();

        this.cardsContainer.setPrefHeight(200);
        this.cardsContainer.setLayoutX(500);
        this.cardsContainer.setLayoutY(700);

        itemsContainer.getChildren().add(this.cardsContainer);
        itemsContainer.getChildren().add(buttonPlayContainer);

        playerJokersView.disableButtons();
        itemsContainer.getChildren().add(playerJokersView);

        playerTarotsView.changeButtons();
        itemsContainer.getChildren().add(playerTarotsView);
        itemsContainer.getChildren().add(turnedDeckView);

        this.roundObserver.addObserverRound(this);

        this.playerObserver.addObserverPlayer(this);

        this.player.addObserverPlayerDeck(this);
        player.addObserverPlayerDeck(this);

        this.getChildren().addAll(itemsContainer);

    }

    public void generateImageCard(){
            this.ImageCards = new HashMap<>();
        try {
            Image deckImage = new Image("file:src/resources/textures/Deck.png");
            int CARD_ROWS = 4;  // filas y columnas del deck.png
            int CARD_COLS = 13;

            double cardWidth = deckImage.getWidth() / CARD_COLS;
            double cardHeight = deckImage.getHeight() / CARD_ROWS;

            int cardsInRow = 8;
            double cardSpacing = 10;

            double startX = ((1920 - (cardsInRow * (cardWidth + cardSpacing) - cardSpacing)) / 2) + 98;
            double startY = 500;

            int cardCounter = 0;
            this.suitsCards.addAll(Arrays.asList("Hearts", "Clubs", "Diamonds", "Spades"));
            this.numbersCards.addAll(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jota", "Reina", "Rey", "As"));

            for (int row = 0; row < CARD_ROWS; row++) {

                HashMap<String,StackPane> mapNumberCards = new HashMap<>();

                for (int col = 0; col < CARD_COLS; col++) {

                    ImageView cardView = new ImageView(deckImage);
                    cardView.setViewport(new javafx.geometry.Rectangle2D(
                            col * cardWidth,  // X de la carta
                            row * cardHeight, // Y de la carta
                            cardWidth,        // Ancho de la carta
                            cardHeight        // Altura de la carta
                    ));

                    cardView.setFitWidth(215);
                    cardView.setFitHeight(175);
                    cardView.setPreserveRatio(true);

                    CardPane cardPane = new CardPane(cardView);

                    cardPane.setLayoutX(startX + (cardCounter * (cardWidth + cardSpacing)));
                    cardPane.setLayoutY(startY);

                    mapNumberCards.put(this.numbersCards.get(col), cardPane);
                    cardCounter++;

                }
                this.ImageCards.put(this.suitsCards.get(row),mapNumberCards);
            }
        } catch (Exception e) {
            System.err.println("Error: No se pudo encontrar el archivo " + "src/resources/textures/Deck.png");
            System.exit(1);
        }
    }

    @Override
    public void updatePlayer(PlayerRecord playerRecord) {
        ArrayList<EnglishCardRecord> cardsRecords = playerRecord.playerDeck().cards();
        List<Node> cards = new ArrayList<>();
        int indexCounter = 0;
        for(EnglishCardRecord cardRecord : cardsRecords){
            //System.out.println("cardRecord: " + cardRecord.toString());
            StackPane card = this.ImageCards.get(cardRecord.suit()).get(cardRecord.number());
            CardPane newCard = new CardPane(card, indexCounter, this.selectecCardIndex, this.player, this.playerObserver);

            cards.add(newCard);
            indexCounter++;
        }
        this.labelHand.setText("");
        this.playsPoints.setText("0");
        this.playsMult.setText("0");
        this.cardsContainer.getChildren().clear();
        this.cardsContainer.getChildren().addAll(cards);
    }

    @Override
    public void update(RoundRecord roundRecord) {
//        System.out.println("UPDATE Round se ejecuto");

        this.roundLabel.setText("Ronda "+roundRecord.number());
        int score = (int) Math.round(roundRecord.scoreToBeat().value());
//        System.out.println("scoreToBeat: " + score);
        this.score.setText("" + score);
        int actualScore = (int) Math.round(roundRecord.actualScore().value());
        this.actualScore.setText("" + actualScore);
//        System.out.println("hands: " + roundRecord.hands());
        this.handsContainerValue.setText( "" + roundRecord.hands());
        this.discardsContainerValue.setText( "" + roundRecord.discards());

        if (this.roundObserver.isGameOver()) {
            GameOverView finalScreen = new GameOverView(this.stage);
            this.getChildren().add(finalScreen);
        }

        if(this.roundObserver.win()){
            WinView winView = new WinView(this.stage,this.player,this.actualRound,this.game,this.playerJokersView,this.playerTarotsView);
            this.getChildren().add(winView);
        }else {
            if (this.roundObserver.winRound()) {

                WinRoundView winRoundView = new WinRoundView(this.stage, this.player, this.actualRound, this.game, this.playerJokersView, this.playerTarotsView);
                this.getChildren().add(winRoundView);
            }
        }
    }

    @Override
    public void updatePlayerDeck(PlayerDeckRecord playerDeckRecord) {

        int points = (int) Math.round(playerDeckRecord.handRecord().points().value());
        int mults = (int) Math.round(playerDeckRecord.handRecord().multiplier().value());

        this.playsPoints.setText("" + points);
        this.playsMult.setText("" + mults);

        this.labelHand.setText(playerDeckRecord.handRecord().name());

        //System.out.println( "Points: " + playerDeckRecord.handRecord().points().value());
        //System.out.println( "Mults: " + playerDeckRecord.handRecord().multiplier().value());
    }
}