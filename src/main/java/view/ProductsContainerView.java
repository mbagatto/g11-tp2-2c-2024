package view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import model.Player;
import model.game.Shop;
import model.jokers.Joker;
import model.tarots.Tarot;

import java.util.ArrayList;

public class ProductsContainerView extends HBox {
    public ProductsContainerView(Player player, ArrayList<Joker> jokers, ArrayList<Tarot> tarots, Shop shop) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setMinWidth(500);
        this.setMaxWidth(500);

        for (Joker joker : jokers) {
            JokerView jokerView = new JokerView(joker, player, shop);
            jokerView.setAddButton();
            this.getChildren().add(jokerView);
        }
        for (Tarot tarot : tarots) {
            TarotView tarotView = new TarotView(tarot, player, shop);
            tarotView.setAddButton();
            this.getChildren().add(tarotView);
        }
    }
}
