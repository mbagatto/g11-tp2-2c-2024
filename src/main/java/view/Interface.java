package view;

import controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Interface extends Application {

    private Controller controller;
    private Stage stage;
    private int points;

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        this.controller = new Controller(this);
        Interface view = new Interface();
        view.setController(this.controller);

        this.showGameScene();

        Image balatroLogo = new Image("file:src/resources/textures/balatro.png");
        ImageView logoImageView = new ImageView(balatroLogo);
        logoImageView.setFitWidth(1000);
        logoImageView.setFitHeight(650);

        Label errorLabel = new Label("¡El nombre no puede estar vacío!");
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        errorLabel.setVisible(false);

        Label welcomeLabel = new Label("Bienvenido!");
        welcomeLabel.setStyle("-fx-font-size: 40px; -fx-text-fill: white; -fx-font-weight: bold;");

        Label instructions = new Label("Introduce tu nombre para continuar: ");
        instructions.setStyle("-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;");

        TextField nameField = new TextField();
        nameField.setPromptText("Introduce tu nombre aqui.");
        nameField.setMaxWidth(300);
        nameField.setMinWidth(150);
        nameField.prefWidthProperty().bind(stage.widthProperty().multiply(0.4));

        Button startButton = new Button("Ingresar");

        Image img = new Image("file:src/resources/textures/cards_2.png");
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        startButton.setGraphic(imageView);

        Image backgroundGif = new Image("file:src/resources/textures/backgroundGIF.gif");
        ImageView backgroundGifView = new ImageView(backgroundGif);
        backgroundGifView.setFitWidth(1920);
        backgroundGifView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundGifView);

        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(logoImageView, welcomeLabel, instructions, nameField, errorLabel, startButton);

        backgroundContainer.getChildren().add(container);

        startButton.setOnAction(e -> {
            String name = nameField.getText();
            controller.handleNameButtonAction(name, stage, errorLabel);
        });

        Scene scene = new Scene(backgroundContainer, 800, 600);
        stage.setTitle("Pantalla de Inicio");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showMenuScene() {

        //Font customFont = Font.loadFont(getClass().getResourceAsStream("src/resources/fonts/m6x11plus.ttf"), 16);

        Image balatroLogo = new Image("file:src/resources/textures/balatro.png");
        ImageView logoImageView = new ImageView(balatroLogo);
        logoImageView.setFitWidth(1000);
        logoImageView.setFitHeight(650);

        HBox buttonFrame = new HBox(12);
        buttonFrame.setAlignment(Pos.CENTER);
        buttonFrame.setStyle(
            "-fx-background-color: #38484D; " +
            "-fx-background-radius: 25px; " +
            "-fx-padding: 14px; " +
            "-fx-border-color: #38484D; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-width: 1px;"
        );

        Button playButton = new Button("JUGAR");
        playButton.setPrefWidth(280);
        playButton.setPrefHeight(95);
        //playButton.setFont(customFont);
        playButton.setStyle(
            "-fx-background-color: #0087F2; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #0087F2; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;"
        );

        Button optionButton = new Button("OPCIONES");
        optionButton.setPrefWidth(280);
        optionButton.setPrefHeight(95);
        //optionButton.setFont(customFont);
        optionButton.setStyle(
            "-fx-background-color: #EC9C00; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 34px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #EC9C00; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;"
        );

        Button quitButton = new Button("SALIR");
        quitButton.setPrefWidth(280);
        quitButton.setPrefHeight(95);
        //quitButton.setFont(customFont);
        quitButton.setStyle(
            "-fx-background-color: #FF453F; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 50px; " +
            "-fx-background-radius: 25px; " +
            "-fx-border-radius: 25px; " +
            "-fx-border-color: #FF453F; " +
            "-fx-border-width: 1px;" +
            "-fx-font-weight: 900;"
        );

        buttonFrame.getChildren().addAll(playButton, optionButton, quitButton);

        HBox horizontalBox = new HBox(12);
        horizontalBox.setAlignment(Pos.CENTER);

        horizontalBox.getChildren().addAll(buttonFrame);

        Image staticBackground = new Image("file:src/resources/textures/static_background.png");
        ImageView backgroundView = new ImageView(staticBackground);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundView);

        playButton.setOnAction(_ -> {
            this.controller.handleButtonClick();
            this.controller.handlePlayAction();
        });

        optionButton.setOnAction(_ -> {
            this.controller.handleButtonClick();
        });

        quitButton.setOnAction(_ -> {
            this.controller.handleButtonClick();
        });

        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(logoImageView, horizontalBox);

        backgroundContainer.getChildren().add(container);

        Scene menuScene = new Scene(backgroundContainer, 1920, 1080);
        stage.setMaximized(true);
        stage.setTitle("Menu Principal");
        stage.setScene(menuScene);

    }

    public void showGameScene() {

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

        Image chipsImage = new Image("file:src/resources/textures/chips.png");
        double x = 60;
        double y = 0;
        double width = 55;
        double height = 55;
        ImageView chipImageView = new ImageView(chipsImage);
        chipImageView.setViewport(new javafx.geometry.Rectangle2D(x, y, width, height));
        chipImageView.setFitWidth(50);
        chipImageView.setFitHeight(50);

        VBox scoreInstructionBox = new VBox(-5);
        scoreInstructionBox.setAlignment(Pos.CENTER);
        scoreInstructionBox.setLayoutX(0);
        scoreInstructionBox.setLayoutY(10);
        scoreInstructionBox.setPrefWidth(roundScore.getPrefWidth());

        Label score = new Label("3000"); // Aca va el score necesario para ganar la ronda
        score.setStyle("-fx-font-size: 45px; -fx-text-fill: red; -fx-font-weight: bold;");
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
        actualScore.setStyle("-fx-font-size: 45px; -fx-text-fill: white; -fx-font-weight: bold;");

       //hboxActualScoreChip.getChildren().addAll(chipImageView, actualScore);
        hboxActualScoreChip.getChildren().addAll(actualScore);

        hboxActualScore.getChildren().addAll(vboxScoreLabel, hboxActualScoreChip);

        actualScoreInfo.getChildren().addAll(hboxActualScore);

        itemsContainer.getChildren().addAll(rectangle, roundTitleFrame, roundInfo, actualScoreInfo);

        backgroundContainer.getChildren().add(itemsContainer);

        Scene gameScene = new Scene(backgroundContainer, 1920, 1080);

        stage.setMaximized(true);
        stage.setTitle("Partida");
        stage.setScene(gameScene);
    }
}
