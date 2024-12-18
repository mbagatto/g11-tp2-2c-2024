package view;

import controller.buttonHandlers.HandlerNewGame;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.buttons.ButtonMusic;
import view.buttons.ButtonYellow;
import view.buttons.MainMenuButtonContainer;
import java.util.Random;

public class MainMenuView extends VBox {
    public MainMenuView(Stage stage) {
        super();
        stage.setTitle("Balatro");
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setPrefSize(1920, 1080);

        Image backgroundGif = new Image("file:src/resources/textures/backgroundGIF.gif");
        BackgroundSize backgroundSize = new BackgroundSize(1920, 1080, true, true, true, true);
        this.setBackground(new Background(new BackgroundImage(backgroundGif, null, null, null, backgroundSize)));

        Image balatroLogo = new Image("file:src/resources/textures/balatro.png");
        ImageView logoImageView = new ImageView(balatroLogo);
        logoImageView.setFitWidth(900);
        logoImageView.setFitHeight(500);
        this.addSwingEffect(logoImageView);
        Label welcomeLabel = new Label("¡Bienvenido!");
        welcomeLabel.setStyle("-fx-font-size: 90px; -fx-text-fill: white;");

        TextField nameField = new TextField();
        nameField.setId("main-menu-namefield");
        nameField.setPromptText("Ingresa tu nombre:");
        nameField.setMaxWidth(500);
        nameField.setMaxHeight(50);
        nameField.setAlignment(Pos.CENTER);

        Label errorLabel = new Label("¡Nombre inválido!");
        errorLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: rgb(251,56,56);");
        errorLabel.setVisible(false);
        nameField.setOnAction(new HandlerNewGame(stage, this, nameField, errorLabel));

        MainMenuButtonContainer buttonContainer = new MainMenuButtonContainer(stage, this, nameField, errorLabel);

        Button continueButton = new ButtonYellow("Continuar");
        continueButton.setVisible(false);

        this.getChildren().add(logoImageView);
        this.getChildren().add(welcomeLabel);
        this.getChildren().add(nameField);
        this.getChildren().add(errorLabel);
        this.getChildren().add(buttonContainer);
        this.getChildren().add(continueButton);
        this.getChildren().add(new ButtonMusic());
    }

    public void addSwingEffect(ImageView image) {

        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), image);
        tt.setFromY(0);
        tt.setToY(-20);
        tt.setCycleCount(Animation.INDEFINITE);
        tt.setAutoReverse(true);
        tt.play();
    }

}
