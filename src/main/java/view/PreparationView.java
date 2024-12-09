package view;

import controller.buttonHandlers.HandlerMainMenuButton;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import model.game.GameDTO;
import model.game.Shop;

public class PreparationView extends Group {
    public PreparationView(MainMenuView mainMenuView, GameDTO gameDTO) {
        super();

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double widthFactor = bounds.getWidth()/1920;
        double heightFactor = bounds.getHeight()/1080;

        Image background = new Image("file:src/resources/textures/game_background.jpg");
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitWidth(1920*widthFactor);
        backgroundView.setFitHeight(1080*widthFactor);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(0);
        rectangle.setWidth(400);
        rectangle.setHeight(1080*widthFactor);
        rectangle.setFill(Color.web("#3B3B3B44"));
        rectangle.setStroke(Color.web("#FFEBA7FF"));
        rectangle.setStrokeWidth(5);

        VBox titleContainer = new VBox();
        titleContainer.setId("title-container");
        titleContainer.setLayoutX(62);
        titleContainer.setLayoutY(100);
        titleContainer.setMinWidth(375);
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setSpacing(2);

        Label title = new Label("TIENDA");
        title.setStyle("-fx-font-size: 100px; -fx-text-fill: white;");

        Label subtitle = new Label("¡Preparate para la siguiente ronda!");
        subtitle.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");

        titleContainer.getChildren().addAll(title, subtitle);

        Button mainMenuButton = new Button("Menú Principal");
        mainMenuButton.setId("main-menu-button");
        mainMenuButton.setLayoutX(100);
        mainMenuButton.setLayoutY(900);
        mainMenuButton.setPrefWidth(300);
        mainMenuButton.setPrefHeight(80);
        mainMenuButton.setOnAction(new HandlerMainMenuButton(mainMenuView));

        this.addView(backgroundView);
        this.addView(rectangle);
        this.addView(titleContainer);
        this.addView(new RoundInfoView(this, gameDTO.round()));
        this.addView(mainMenuButton);

        Shop shop =  gameDTO.round().toDTO().shop();
        this.addView(new PlayerJokersContainer(this, gameDTO.player(), shop));
        this.addView(new PlayerTarotsContainer(this, gameDTO.player(), shop));
        this.addView(new ProductsContainer(this, gameDTO.player(), shop));
        this.addView(new EnglishDeckView(this, gameDTO.player().toDTO().englishDeck()));
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
        this.getChildren().remove(view);
        this.getChildren().add(view);
    }
}
