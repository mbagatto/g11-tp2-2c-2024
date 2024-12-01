package view;

import controller.Controller;
import javafx.application.Application;
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

public class Interface extends Application {

    private Controller controller;
    private Stage stage;

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
        horizontalBox.setAlignment(Pos.BOTTOM_CENTER);

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
        rectangle.setFill(Color.web("#10191D"));
        rectangle.setStroke(Color.web("#004A7B"));
        rectangle.setStrokeWidth(3);

        HBox roundTitleFrame = new HBox(10);
        roundTitleFrame.setAlignment(Pos.CENTER);
        roundTitleFrame.setStyle(
                "-fx-background-color: #004A7B; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-padding: 14px; " +
                        "-fx-border-color: #004A7B; " +
                        "-fx-border-radius: 25px; " +
                        "-fx-border-width: 1px;"
        );
        roundTitleFrame.setLayoutX(60);
        roundTitleFrame.setLayoutY(20);
        roundTitleFrame.setPrefHeight(8);
        roundTitleFrame.setPrefWidth(380);

        Label roundLabel = new Label("Ronda 1"); // Deberia ir el numero de ronda actual
        roundLabel.setStyle("-fx-font-size: 50px; -fx-text-fill: white; -fx-font-weight: 900;");

        roundTitleFrame.getChildren().add(roundLabel);

        Pane roundInfo = new Pane();
        roundInfo.setLayoutX(60);
        roundInfo.setLayoutY(135);
        roundInfo.setPrefHeight(300);
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
        whiteCoinView.setLayoutX(15);
        whiteCoinView.setLayoutY(75);

        Pane roundScore = new Pane();
        roundScore.setLayoutX(165);
        roundScore.setLayoutY(75);
        roundScore.setPrefHeight(130);
        roundScore.setPrefWidth(200);
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
        chipImageView.setFitWidth(30);
        chipImageView.setFitHeight(30);

        VBox scoreInstructionBox = new VBox(30);
        scoreInstructionBox.setAlignment(Pos.CENTER);
        scoreInstructionBox.getChildren().addAll(scoreInstructionLabel, chipImageView);
        scoreInstructionBox.setLayoutX(0);
        scoreInstructionBox.setLayoutY(10);
        scoreInstructionBox.setPrefWidth(roundScore.getPrefWidth());

        roundScore.getChildren().addAll(scoreInstructionBox);

        roundInfo.getChildren().addAll(whiteCoinView, roundScore);

        itemsContainer.getChildren().addAll(rectangle, roundTitleFrame, roundInfo);

        backgroundContainer.getChildren().add(itemsContainer);

        Scene gameScene = new Scene(backgroundContainer, 1920, 1080);

        stage.setMaximized(true);
        stage.setTitle("Partida");
        stage.setScene(gameScene);
    }
}
