package view;

import controller.buttonHandlers.HandlerAddJoker;
import controller.buttonHandlers.HandlerAddTarot;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import model.Player;
import model.game.Shop;
import model.jokers.Joker;
import model.tarots.Tarot;
import view.buttons.ButtonSpecialCard;

import java.util.ArrayList;

public class ProductsContainerView extends HBox {
    public ProductsContainerView(Player player, ArrayList<Joker> jokers, ArrayList<Tarot> tarots, Shop shop) {
        super();
        this.setId("products-container-view");
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setMaxWidth(500);
        this.setPrefHeight(250);

        for (Joker joker : jokers) {
            JokerView jokerView = new JokerView(joker, player);
            jokerView.addButton(new ButtonSpecialCard(), new HandlerAddJoker(player, joker, shop));
            this.getChildren().add(jokerView);
        }
        for (Tarot tarot : tarots) {
            TarotView tarotView = new TarotView(tarot, player);
            tarotView.addButton(new ButtonSpecialCard(), new HandlerAddTarot(player, tarot, shop));
            this.getChildren().add(tarotView);
        }
    }
}
