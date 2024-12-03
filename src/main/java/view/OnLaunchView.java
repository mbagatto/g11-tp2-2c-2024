package view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.buttons.ButtonStart;

public class OnLaunchView extends Group {

    public OnLaunchView(Stage stage) {
        stage.setTitle("Balatro");
        Image balatroLogo = new Image("file:src/resources/textures/balatro.png");
        ImageView logoImageView = new ImageView(balatroLogo);
        logoImageView.setFitWidth(1000);
        logoImageView.setFitHeight(650);

        Label welcomeLabel = new Label("Welcome!");
        welcomeLabel.setStyle("-fx-font-size: 90px; -fx-text-fill: white;");

        Label instructions = new Label("Enter your name to continue: ");
        instructions.setStyle("-fx-font-size: 35px; -fx-text-fill: white;");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name:");
        nameField.setMaxWidth(400);
        nameField.setMinHeight(30);
        nameField.setStyle("-fx-font-size: 20px;");

        Label errorLabel = new Label("Name can't be empty!");
        errorLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: red");
        errorLabel.setVisible(false);

        Image backgroundGif = new Image("file:src/resources/textures/backgroundGIF.gif");
        ImageView backgroundGifView = new ImageView(backgroundGif);
        backgroundGifView.setFitWidth(1920);
        backgroundGifView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundGifView);

        VBox container = new VBox(8);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(logoImageView, welcomeLabel, instructions, nameField, errorLabel, new ButtonStart(stage, nameField, errorLabel));
        backgroundContainer.getChildren().add(container);

        this.addView(backgroundContainer);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}
