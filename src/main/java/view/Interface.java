package view;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.*;


public class Interface extends Application {

    private Controller controller;
    private Stage stage;

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        this.controller = new Controller(this);
        Interface view = new Interface();
        view.setController(this.controller);

        Image balatroLogo = new Image("file:src/resources/balatro.png");
        ImageView logoImageView = new ImageView(balatroLogo);
        logoImageView.setFitWidth(400);
        logoImageView.setFitHeight(300);

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

        Image img = new Image("file:src/resources/cards_2.png");
        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        startButton.setGraphic(imageView);

        Image backgroundGif = new Image("file:src/resources/backgroundGIF.gif");
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

        Scene scene = new Scene(backgroundContainer, 200, 100);
        stage.setTitle("Pantalla de Inicio");
        stage.setScene(scene);


        stage.setMaximized(true);
        stage.show();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public static void main(String[] args) { // Sin este main no funciona la interfaz
        launch(args);
    }

    public void showMenuScene() {
        VBox menuContainer = new VBox(20);
        Label menuLabel = new Label("Bienvenido al Menú Principal");
        menuLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: white; -fx-font-weight: bold;");
        menuContainer.getChildren().add(menuLabel);

        Image staticBackground = new Image("file:src/resources/static_background.png");
        ImageView backgroundView = new ImageView(staticBackground);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundView);

        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(menuLabel);

        backgroundContainer.getChildren().add(container);

        Scene menuScene = new Scene(backgroundContainer, 1920, 1080);
        stage.setMaximized(true);
        stage.setTitle("Menu Principal");
        stage.setScene(menuScene);

    }
}
