package view;

import controller.buttonHandlers.HandlerStart;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OnLaunchView extends Group {

    public OnLaunchView(Stage stage) {
        stage.setTitle("Balatro");
        Image balatroLogo = new Image("file:src/resources/textures/balatro.png");
        ImageView logoImageView = new ImageView(balatroLogo);
        logoImageView.setFitWidth(1000);
        logoImageView.setFitHeight(650);

        Label welcomeLabel = new Label("¡Bienvenido!");
        welcomeLabel.setStyle("-fx-font-size: 90px; -fx-text-fill: white;");

        Label errorLabel = new Label("¡Nombre inválido!");
        errorLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: red");
        errorLabel.setVisible(false);

        Image backgroundGif = new Image("file:src/resources/textures/backgroundGIF.gif");
        ImageView backgroundGifView = new ImageView(backgroundGif);
        backgroundGifView.setFitWidth(1920);
        backgroundGifView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundGifView);

        HBox nameFieldContainer = new HBox();
        nameFieldContainer.setMaxWidth(450);
        nameFieldContainer.setId("namefield-container");
        nameFieldContainer.setAlignment(Pos.CENTER);
        nameFieldContainer.setSpacing(2);

        TextField nameField = new TextField();
        nameField.setId("namefield");
        nameField.setPromptText("Ingresa tu nombre:");
        nameField.setPrefWidth(400);
        nameField.setPrefHeight(50);

        Button continueButton = new Button(">");
        continueButton.setId("button-continue");
        continueButton.setPrefWidth(50);
        continueButton.setPrefHeight(50);
        continueButton.setOnAction(new HandlerStart(stage, nameField, errorLabel));

        nameFieldContainer.getChildren().add(nameField);
        nameFieldContainer.getChildren().add(continueButton);

        VBox container = new VBox(3);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(logoImageView, welcomeLabel, nameFieldContainer, errorLabel);
        backgroundContainer.getChildren().add(container);

        container.requestFocus();
        this.addView(backgroundContainer);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}
