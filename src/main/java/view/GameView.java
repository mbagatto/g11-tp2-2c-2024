package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.ObserverPlayer;
import model.ObserverRound;
import model.Player;
import model.decks.EnglishDeck;
import model.game.Round;
import model.reader.DataReader;
import view.buttons.ButtonDiscardHand;
import view.buttons.ButtonPlayHand;
import view.records.EnglishCardRecord;
import view.records.PlayerRecord;
import view.records.RoundRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameView extends StackPane implements ObserverPlayer, ObserverRound {

    private HashMap<String,HashMap<String,StackPane>> ImageCards;
    private List<String> numbersCards = new ArrayList<>();
    private List<String> suitsCards = new ArrayList<>();
    //player
    private PlayerObserver playerObserver;
    private List<Integer> selectecCardIndex;
    //round
    private RoundObserver roundObserver;
    private Label roundLabel;
    private Label score;
    private Label actualScore;
    private Label handsContainerValue;
    private Label discardsContainerValue;

    private HBox cardsContainer;

    public GameView(Stage stage,Player player)  {
        this.selectecCardIndex = new ArrayList<>();

        EnglishDeck deck = new EnglishDeck();
        deck.fillDeck();
        deck.shuffleDeck();
        Player newPlayer = new Player("new",deck);
        newPlayer.completeDeck();
        this.playerObserver = new PlayerObserver(newPlayer);
        DataReader reader = new DataReader();
        ArrayList<Round> rounds = reader.roundsRead();

        this.roundObserver = new RoundObserver(rounds.getFirst());

        Image staticBackground = new Image("file:src/resources/textures/static_game_background.png");
        ImageView backgroundView = new ImageView(staticBackground);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        this.getChildren().add(backgroundView);

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

        this.roundLabel = new Label("*Ronda-1-*"); // Deberia ir el numero de ronda actual
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

        this.score = new Label("9000"); // Aca va el score necesario para ganar la ronda
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
        actualScoreInfo.setPrefWidth(385);
        actualScoreInfo.setStyle(
                "-fx-background-color: #111D1C; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-border-color: #111D1C; " +
                        "-fx-border-width: 1px; " +
                        "-fx-border-radius: 25px;"
        );

        VBox vboxScoreLabel = new VBox();
        vboxScoreLabel.setAlignment(Pos.CENTER);
        vboxScoreLabel.setPrefHeight(50); // Ajusta a un valor más pequeño

        Label wordRound = new Label("Ronda");
        wordRound.setStyle("-fx-font-size: 40px; -fx-text-fill: white; -fx-font-weight: bold;");

        Label puntuation = new Label("puntuacion");
        puntuation.setStyle("-fx-font-size: 30px; -fx-text-fill: white; -fx-font-weight: bold;");

        vboxScoreLabel.getChildren().addAll(wordRound, puntuation);
        vboxScoreLabel.setMargin(wordRound, new Insets(0, 0, 0, 0));
        vboxScoreLabel.setMargin(puntuation, new Insets(0, 0, 0, 0));

        HBox hboxActualScore = new HBox(5);
        hboxActualScore.setAlignment(Pos.CENTER);
        hboxActualScore.setLayoutX(10);
        hboxActualScore.setLayoutY(15);
        hboxActualScore.setPrefWidth(380);

        HBox hboxActualScoreChip = new HBox(5);
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

        this.actualScore = new Label("666");
        actualScore.setStyle("-fx-font-size: 45px; -fx-text-fill: #C0C6C6; -fx-font-weight: bold;");

        hboxActualScoreChip.getChildren().addAll(chipImageView2, actualScore);

        hboxActualScore.getChildren().addAll(vboxScoreLabel, hboxActualScoreChip);

        actualScoreInfo.getChildren().addAll(hboxActualScore);

        //Arranca

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
                        + "-fx-padding: 0 0 0 5px;"
        );

        playsContainer.getChildren().addAll(playsPoints, playsSymbol, playsMult);

        HBox roundInfoContainer = new HBox(10);
        roundInfoContainer.setLayoutX(145);
        roundInfoContainer.setLayoutY(800);
        roundInfoContainer.setAlignment(Pos.CENTER);

        VBox roundInfoHandsContainer = new VBox(5);
        roundInfoHandsContainer.setMinWidth(100);
        roundInfoHandsContainer.setPrefHeight(100);
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

        this.handsContainerValue = new Label("7");
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
        roundInfoDiscardsContainer.setMinWidth(100);
        roundInfoDiscardsContainer.setPrefHeight(100);
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

        this.discardsContainerValue = new Label("7");
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

        itemsContainer.getChildren().addAll(rectangle, roundTitleFrame, roundInfo, actualScoreInfo, playsContainer, roundInfoContainer);

        HBox buttonPlayContainer = new HBox(10);
        buttonPlayContainer.setPrefHeight(200);
        buttonPlayContainer.setLayoutX(800);
        buttonPlayContainer.setLayoutY(950);

        buttonPlayContainer.getChildren().add(new ButtonPlayHand(this.playerObserver,this.roundObserver,this.selectecCardIndex));
        buttonPlayContainer.getChildren().add(new ButtonDiscardHand(this.playerObserver,this.roundObserver,this.selectecCardIndex));

        this.generateImageCard();

        this.cardsContainer = new HBox();

        this.cardsContainer.setPrefHeight(200);
        this.cardsContainer.setLayoutX(500);
        this.cardsContainer.setLayoutY(700);

        itemsContainer.getChildren().add(this.cardsContainer);
        itemsContainer.getChildren().add(buttonPlayContainer);

        this.roundObserver.addObserverRound(this);

        this.playerObserver.addObserverPlayer(this);
        this.getChildren().add(itemsContainer);

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

            for (int row = 0; row < CARD_ROWS; row++) {         //Este for deberia recorrer con el siguiente orden: Corazon, Trebol, Diamante, Pica
                // Son 13 cartas por cada fila
                HashMap<String,StackPane> mapNumberCards = new HashMap<>();

                for (int col = 0; col < CARD_COLS; col++) {

                    ImageView cardView = new ImageView(deckImage);
                    cardView.setViewport(new javafx.geometry.Rectangle2D(
                            col * cardWidth,  // X de la carta
                            row * cardHeight, // Y de la carta
                            cardWidth,        // Ancho de la carta
                            cardHeight        // Altura de la carta
                    ));

                    cardView.setFitWidth(160);
                    cardView.setFitHeight(200);
                    cardView.setPreserveRatio(true);

                    CardPane cardPane = new CardPane(cardView);

                    cardPane.setLayoutX(startX + (cardCounter * (cardWidth + cardSpacing)));
                    cardPane.setLayoutY(startY);

//                    if (cardCounter >= cardsInRow) {
//                        cardPane.setLayoutX(1600);
//                        cardPane.setLayoutY(760);
//                    }
                    System.out.println("number: " + this.numbersCards.get(col));
                    mapNumberCards.put(this.numbersCards.get(col), cardPane);
                    cardCounter++;

                }
                System.out.println("Suit: " + this.suitsCards.get(row));
                this.ImageCards.put(this.suitsCards.get(row),mapNumberCards);
            }
        } catch (Exception e) {
            System.err.println("Error: No se pudo encontrar el archivo " + "src/resources/textures/Deck.png");
            System.exit(1);
        }
    }

    @Override
    public void updatePlayer(PlayerRecord playerRecord) {
        System.out.println("UPDATE Player se ejecuto");

        System.out.println("CANTIDAD DE CARTAS: "+playerRecord.playerDeck().cards().size());

        System.out.println("CARTAR A AGREGAR O ACTUALIZAR: "+playerRecord.playerDeck().cards().toString());

        ArrayList<EnglishCardRecord> cardsRecords = playerRecord.playerDeck().cards();
        List<Node> cards = new ArrayList<>();
        int indexCounter = 0;
        for(EnglishCardRecord cardRecord : cardsRecords){
            System.out.println("cardRecord: " + cardRecord.toString());
            StackPane card = this.ImageCards.get(cardRecord.suit()).get(cardRecord.number());
            CardPane newCard = new CardPane(card,indexCounter,this.selectecCardIndex);

            cards.add(newCard);
            indexCounter++;
        }

        this.cardsContainer.getChildren().clear();
        this.cardsContainer.getChildren().addAll(cards);
    }

    @Override
    public void update(RoundRecord roundRecord) {
        System.out.println("UPDATE Round se ejecuto");

        this.roundLabel.setText("Ronda "+roundRecord.number());
        int score = (int) Math.round(roundRecord.scoreToBeat().value());
        System.out.println("scoreToBeat: " + score);
        this.score.setText("" + score);
        int actualScore = (int) Math.round(roundRecord.actualScore().value());
        this.actualScore.setText("" + actualScore);
        System.out.println("hands: " + roundRecord.hands());
        this.handsContainerValue.setText( "" + roundRecord.hands());
        this.discardsContainerValue.setText( "" + roundRecord.discards());
    }
}

//    private void makeCardDraggable(Pane cardPane) {
//        final double[] offsetX = {0};
//        final double[] offsetY = {0};
//        final boolean[] isDragging = {false}; // Variable para saber si hubo arrastre
//        cardPane.setOnMousePressed(event -> {
//            offsetX[0] = event.getSceneX() - cardPane.getLayoutX();
//            offsetY[0] = event.getSceneY() - cardPane.getLayoutY();
//            isDragging[0] = false;
//        });
//        cardPane.setOnMouseDragged(event -> {
//            cardPane.setLayoutX(event.getSceneX() - offsetX[0]);
//            cardPane.setLayoutY(event.getSceneY() - offsetY[0]);
//            isDragging[0] = true;
//        });
//        cardPane.setOnMouseReleased(event -> {
//            if (!isDragging[0]) {
//                cardPane.setLayoutY(cardPane.getLayoutY() - 70); // aca se le dice cuanto debe subir, en este caso 70 pixeles creo que esta bien
//            }
//        });
//    }

//Todo lo que esta de aca para abajo hay que ordenarlo y refactorizarlo



//        try {
//            Image deckImage = new Image("file:src/resources/textures/Deck.png");
//            int CARD_ROWS = 4;  // filas y columnas del deck.png
//            int CARD_COLS = 13;
//
//            double cardWidth = deckImage.getWidth() / CARD_COLS;
//            double cardHeight = deckImage.getHeight() / CARD_ROWS;
//
//            int cardsInRow = 8;
//            double cardSpacing = 10;
//
//            double startX = ((1920 - (cardsInRow * (cardWidth + cardSpacing) - cardSpacing)) / 2) + 98;
//            double startY = 500;
//
//            int cardCounter = 0;
//
//            for (int row = 0; row < CARD_ROWS; row++) {         //Este for deberia recorrer con el siguiente orden: Corazon, Trebol, Diamante, Pica
//                                                                // Son 13 cartas por cada fila
//                for (int col = 0; col < CARD_COLS; col++) {
//
//                    ImageView cardView = new ImageView(deckImage);
//                    cardView.setViewport(new javafx.geometry.Rectangle2D(
//                            col * cardWidth,  // X de la carta
//                            row * cardHeight, // Y de la carta
//                            cardWidth,        // Ancho de la carta
//                            cardHeight        // Altura de la carta
//                    ));
//
//                    cardView.setFitWidth(160);
//                    cardView.setFitHeight(200);
//                    cardView.setPreserveRatio(true);
//
//                    StackPane cardPane = new StackPane();
//                    cardPane.setStyle(
//                            "-fx-background-color: white; " +
//                                    "-fx-border-color: black; " +
//                                    "-fx-border-radius: 10; " +
//                                    "-fx-background-radius: 10;"
//                    );
//                    cardPane.setPrefSize(160, 200); // esta es la parte blanca de la carta
//                    cardPane.getChildren().add(cardView);
//
//                    makeCardDraggable(cardPane);
//
//                    cardPane.setLayoutX(startX + (cardCounter * (cardWidth + cardSpacing)));
//                    cardPane.setLayoutY(startY);
//
//                    if (cardCounter >= cardsInRow) {
//                        cardPane.setLayoutX(1600);
//                        cardPane.setLayoutY(760);
//                    }
//                    itemsContainer.getChildren().add(cardPane);
//                    cardCounter++;
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Error: No se pudo encontrar el archivo " + "src/resources/textures/Deck.png");
//            System.exit(1);
//        }
