package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Observer;
import model.Player;
import model.game.Game;
import model.game.Round;
import model.jokers.Joker;
import model.tarots.Tarot;

import java.util.ArrayList;

public class PreparationView extends VBox implements Observer {
    private Stage stage;
    private Round round;
    private Player player;
    private Game game;

    public PreparationView(Stage stage, Round round, Player player, Game game) {
        this.stage = stage;
        this.round = round;
        this.player = player;
        this.game = game;
        round.addObserver(this);
        player.addObserver(this);
        this.update();
    }

    @Override
    public void update() {
        stage.setTitle("Balatro - Preparation");

        Image background = new Image("file:src/resources/textures/game_background.jpg");
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitWidth(1920);
        backgroundView.setFitHeight(1080);

        StackPane backgroundContainer = new StackPane();
        backgroundContainer.getChildren().add(backgroundView);

        Pane itemsContainer = new Pane();

        Rectangle leftRectangle = new Rectangle();
        leftRectangle.setX(50);
        leftRectangle.setY(0);
        leftRectangle.setWidth(400);
        leftRectangle.setHeight(1080);
        leftRectangle.setFill(Color.web("#3B3B3B44"));
        leftRectangle.setStroke(Color.web("#FFEBA7FF"));
        leftRectangle.setStrokeWidth(5);

        itemsContainer.getChildren().add(leftRectangle);
        itemsContainer.getChildren().add(new ShopTitleContainer());
        itemsContainer.getChildren().add(new LeftPanelView(round));

        ArrayList<Joker> jokers = this.round.getShop().getJokers();
        ArrayList<Tarot> tarots = this.round.getShop().getTarots();

        VBox playerJokers = new PlayerJokersContainer(player);
        VBox playerTarots = new PlayerTarotsContainer(player);

        itemsContainer.getChildren().add(playerJokers);
        itemsContainer.getChildren().add(playerTarots);

        itemsContainer.getChildren().add(new ShopContainer(stage, playerJokers, playerTarots, jokers, tarots, player, round, this.game));
        itemsContainer.getChildren().add(new TurnedDeckView(player.getEnglishDeck()));

        backgroundContainer.getChildren().add(itemsContainer);

        this.getChildren().addAll(backgroundContainer);
    }
}
