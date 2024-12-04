package view;

import controller.buttonHandlers.HandlerAddJoker;
import controller.buttonHandlers.HandlerAddTarot;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Player;
import model.game.Game;
import model.game.Round;
import model.jokers.Joker;
import model.tarots.Tarot;
import view.buttons.ButtonNextRound;

import java.util.ArrayList;
import java.util.Collections;

public class ShopContainer extends VBox {
    public ShopContainer(Stage stage, VBox playerJokers, VBox playerTarots, ArrayList<Joker> jokers, ArrayList<Tarot> tarots, Player player, Round actualRound, Game game) {
        super();
        this.setId("shop-container");
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(8);
        this.setLayoutX(550);
        this.setLayoutY(305);
        this.setMinWidth(900);
        this.setMinHeight(750);

        ArrayList<VBox> products = new ArrayList<>();

        for (Joker joker : jokers) {
            VBox jokerView = new PurchasableView(joker);
            Button addButton = (Button) jokerView.getChildren().get(1);
            addButton.setOnAction(new HandlerAddJoker(jokerView, playerJokers, this, player, joker));
            products.add(jokerView);
        }

        for (Tarot tarot : tarots) {
            VBox tarotView = new PurchasableView(tarot);
            Button addButton = (Button) tarotView.getChildren().get(1);
            addButton.setOnAction(new HandlerAddTarot(tarotView, playerTarots, this, player, tarot));
            products.add(tarotView);
        }

        Collections.shuffle(products);

        this.getChildren().add(new ButtonNextRound(stage, player, actualRound,game));
        this.getChildren().addAll(products.subList(0, 4));
    }
}
