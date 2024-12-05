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
    public ShopContainer(Stage stage, Round round, Player player, Game game, ArrayList<Joker> jokers, ArrayList<Tarot> tarots, PlayerJokersView playerJokersView, PlayerTarotsView playerTarotsView) {
        super();
        this.setId("shop-container");
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(8);
        this.setLayoutX(550);
        this.setLayoutY(305);
        this.setPrefWidth(900);
        this.setPrefHeight(800);

        ArrayList<VBox> productViews = new ArrayList<>();

        for (Joker joker : jokers) {
            VBox shopProductView = new ShopProductView(joker);
            Button addButton = ((Button) shopProductView.getChildren().get(1));
            addButton.setOnAction(new HandlerAddJoker(player, joker, this, shopProductView, playerJokersView));
            productViews.add(shopProductView);
        }

        for (Tarot tarot : tarots) {
            VBox shopProductView = new ShopProductView(tarot);
            Button addButton = ((Button) shopProductView.getChildren().get(1));
            addButton.setOnAction(new HandlerAddTarot(player, tarot, this, shopProductView, playerTarotsView));
            productViews.add(shopProductView);
        }

        Collections.shuffle(productViews);

        this.getChildren().add(new ButtonNextRound(stage, player, round, game, playerJokersView, playerTarotsView));
        this.getChildren().addAll(productViews.subList(0, 4));
    }

    public void addProduct(VBox productView) {
        this.getChildren().add(productView);
    }

    public void removeProduct(VBox productView) {
        this.getChildren().remove(productView);
    }
}
