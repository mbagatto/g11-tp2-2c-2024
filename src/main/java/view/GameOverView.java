package view;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameOverView extends VBox {

    public GameOverView(Stage stage) {
        Label label = new Label("PERDISTE");
        label.setFont(Font.font("Arial", 70));
        label.setTextFill(Color.WHITE);

        StackPane gameOverScreen = new StackPane();
        gameOverScreen.setStyle("-fx-background-color: #ff4d4d; -fx-border-radius: 15;");

        label.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.7), 10, 0.5, 2, 2);");

        gameOverScreen.getChildren().add(label);

        Scene scene = new Scene(gameOverScreen, 1920, 1080);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setTitle("Juego Terminado");
        stage.show();

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
            Platform.exit();
        });
        pause.play();
    }
}
