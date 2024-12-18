package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.decks.PlayerDeck;
import model.game.Game;
import view.buttons.ButtonOptions;
import model.game.Shop;
import view.dtos.GameDTO;

public class RoundGameView extends Group {
    public RoundGameView(Stage stage, MainMenuView mainMenuView, Game game) {
        super();

        Image background = new Image("file:src/resources/textures/game_background.jpg");
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(0);
        rectangle.setWidth(400);
        rectangle.setHeight(1080);
        rectangle.setFill(Color.web("#3B3B3B44"));
        rectangle.setStroke(Color.web("#FFEBA7FF"));
        rectangle.setStrokeWidth(5);

        GameDTO gameDTO = game.toDTO();

        Button optionsButton = new ButtonOptions(stage, mainMenuView, this);

        PlayerDeck playerDeck = gameDTO.player().toDTO().playerDeck();

        this.addView(backgroundView);
        this.addView(rectangle);
        this.addView(new RoundTitleView(gameDTO.round()));
        this.addView(new RoundInfoView(this, game.toDTO().round(), playerDeck));
        this.addView(optionsButton);

        Shop shop = gameDTO.round().toDTO().shop();

        PlayerJokersContainer playerJokersContainer = new PlayerJokersContainer(this, gameDTO.player(), shop);
        this.addView(playerJokersContainer);

        PlayerTarotsContainer playerTarotsContainer = new PlayerTarotsContainer(this, gameDTO.player(), shop, true);
        playerTarotsContainer.setUseButtonEnabled();
        this.addView(playerTarotsContainer);

        PlayerDeckContainer playerDeckContainer = new PlayerDeckContainer(this, playerDeck, gameDTO.player(), gameDTO.round(), stage, mainMenuView, game);
        this.addView(playerDeckContainer);

        this.addView(new EnglishDeckView(this, gameDTO.player().toDTO(). englishDeck()));
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}
