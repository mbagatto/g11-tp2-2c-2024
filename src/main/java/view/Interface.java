package view;

import controller.Controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.game.Game;
import model.game.Round;
import model.reader.RoundReader;
import javax.swing.*;
import java.util.ArrayList;

public class Interface extends Application {

    private Controller controller;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.controller = new Controller(this);
        Interface view = new Interface();
        view.setController(this.controller);
        showHomePage();
    }

    public void showHomePage() {
        Image balatroLogo = new Image("file:src/resources/textures/balatro.png");
        ImageView logoImageView = new ImageView(balatroLogo);
        logoImageView.setFitWidth(1000);
        logoImageView.setFitHeight(650);

        Label errorLabel = new Label("Name can't be empty!");
        errorLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: red");
        errorLabel.setVisible(false);

        Label welcomeLabel = new Label("Welcome!");
        welcomeLabel.setStyle("-fx-font-size: 90px; -fx-text-fill: white;");

        Label instructions = new Label("Enter your name to continue: ");
        instructions.setStyle("-fx-font-size: 35px; -fx-text-fill: white;");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name:");
        nameField.setMaxWidth(400);
        nameField.setMinHeight(30);
        nameField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    String name = nameField.getText();
                    controller.handleNameButtonAction(name, errorLabel);
                }
            }
        });
        nameField.setStyle("-fx-font-size: 20px;");

        Button startButton = new Button("Start Game");
        startButton.setMinWidth(200);
        startButton.setMinHeight(30);
        startButton.setStyle("-fx-cursor: hand; -fx-font-size: 20px;");

        Image backgroundGif = new Image("file:src/resources/textures/backgroundGIF.gif");
        ImageView backgroundGifView = new ImageView(backgroundGif);
        backgroundGifView.setFitWidth(1920);
        backgroundGifView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundGifView);

        VBox container = new VBox(8);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(logoImageView, welcomeLabel, instructions, nameField, errorLabel, startButton);

        backgroundContainer.getChildren().add(container);

        startButton.setOnAction(e -> {
            String name = nameField.getText();
            controller.handleNameButtonAction(name, errorLabel);
        });

        Scene scene = new Scene(backgroundContainer);
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setTitle("Balatro - Home");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showMenuScene(String playerName) {
        Image balatroLogo = new Image("file:src/resources/textures/balatro.png");
        ImageView logoImageView = new ImageView(balatroLogo);
        logoImageView.setFitWidth(1000);
        logoImageView.setFitHeight(650);

        HBox buttonFrame = new HBox(12);
        buttonFrame.setAlignment(Pos.CENTER);
        buttonFrame.setStyle(
            "-fx-background-color: rgba(0,0,0,0); " +
            "-fx-padding: 14px; " +
            "-fx-border-color: rgba(0,0,0,0); " +
            "-fx-border-radius: 25px; " +
            "-fx-border-width: 1px;"
        );

        Button playButton = new Button("PLAY");
        playButton.setPrefWidth(280);
        playButton.setPrefHeight(95);
        playButton.setStyle(
                        "-fx-background-color: rgb(0,104,216);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 50px; " +
                        "-fx-cursor: hand;"
        );

        Button quitButton = new Button("QUIT");
        quitButton.setPrefWidth(280);
        quitButton.setPrefHeight(95);
        quitButton.setStyle(
                        "-fx-background-color: rgb(248,74,74);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 50px; " +
                        "-fx-cursor: hand;"
        );

        buttonFrame.getChildren().addAll(playButton, quitButton);

        HBox horizontalBox = new HBox(12);
        horizontalBox.setAlignment(Pos.BOTTOM_CENTER);

        horizontalBox.getChildren().addAll(buttonFrame);

        Image staticBackground = new Image("file:src/resources/textures/static_background.png");
        ImageView backgroundView = new ImageView(staticBackground);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundView);



        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(logoImageView, horizontalBox);

        backgroundContainer.getChildren().add(container);

        Scene menuScene = new Scene(backgroundContainer, 1920, 1080);

        playButton.setOnAction(e -> {
            this.controller.handleButtonClick();
            this.controller.handlePlayAction(playerName);
        });

        quitButton.setOnAction(e -> {
            this.controller.handleButtonClick();
            this.controller.handleQuitAction(menuScene);
        });

        menuScene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setMaximized(true);
        stage.setTitle("Balatro - Menu");
        stage.setScene(menuScene);
    }

    public void showRoundMenuScene(Game game) {
        ArrayList<Round> rounds = (new RoundReader()).read("/cardsInfo/balatro.json");
        game.setRounds(rounds);

        Label chooseRoundLabel = new Label("Choose Round:");
        chooseRoundLabel.setStyle("-fx-font-size: 75px; -fx-text-fill: white;");

        HBox firstRow = new HBox();
        firstRow.setAlignment(Pos.CENTER);
        HBox secondRow = new HBox();
        secondRow.setAlignment(Pos.CENTER);
        ArrayList<VBox> roundsButtons = new ArrayList<>();


        for (int i = 0; i < rounds.size(); i++) {
            VBox roundButtonContainer = new VBox();
            Button roundButton = new Button("Round " + rounds.get(i).getNumber());
            roundButton.setStyle("-fx-background-color: rgb(248,74,74);" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 50px; " +
                    "-fx-cursor: hand;");
            roundButton.setMinHeight(75);
            roundButton.setMinWidth(380);
            Text hands = new Text(rounds.get(i).getHands());
            hands.setFill(Color.rgb(248, 74, 74));
            Text discards = new Text(rounds.get(i).getDiscards());
            discards.setFill(Color.rgb(248, 74, 74));
            Text scoreToBeat = new Text(rounds.get(i).getScoreToBeat());
            scoreToBeat.setFill(Color.rgb(248, 74, 74));
            Label roundDescription = new Label(
                    "Hands: " + hands.getText() + "    "
                            + "Discards: " + discards.getText() + "    "
                            + "Score: " + scoreToBeat.getText() + "    "
            );
            roundDescription.setStyle("-fx-font-size: 30px; -fx-text-fill: white;");

            if (i != 0 && !rounds.get(i-1).wonRound()) {
                roundButton.setDisable(true);
                roundDescription.setStyle("-fx-font-size: 30px; -fx-text-fill: rgba(255,255,255,0.29);");
            }

            roundButtonContainer.getChildren().addAll(roundButton, roundDescription);
            roundsButtons.add(roundButtonContainer);
        }

        firstRow.getChildren().addAll(roundsButtons.subList(0, 4));
        secondRow.getChildren().addAll(roundsButtons.subList(4, 8));

        VBox container = new VBox(30);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(chooseRoundLabel, firstRow, secondRow);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(container);
        borderPane.setStyle("-fx-background-color: rgba(0,0,0,0.77);");

        Scene roundMenuScene = new Scene(borderPane, 1920, 1080);
        roundMenuScene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setMaximized(true);
        stage.setTitle("Balatro - Round Menu");
        stage.setScene(roundMenuScene);
    }
}
