package view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Player;

public class MenuView extends VBox {

    public MenuView(Stage stage, Player player) {
        stage.setTitle("Balatro - Menu");
        Image balatroLogo = new Image("file:src/resources/textures/balatro.png");
        ImageView logoImageView = new ImageView(balatroLogo);
        logoImageView.setFitWidth(1000);
        logoImageView.setFitHeight(650);

        HBox horizontalBox = new HBox(12);
        horizontalBox.setAlignment(Pos.BOTTOM_CENTER);
        horizontalBox.getChildren().add(new MenuButtonContainer(stage, player));

        Image staticBackground = new Image("file:src/resources/textures/game_background.jpg");
        ImageView backgroundView = new ImageView(staticBackground);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundView);

        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(logoImageView, horizontalBox);

        backgroundContainer.getChildren().add(container);

        this.addView(backgroundContainer);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}
