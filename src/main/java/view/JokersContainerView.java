package view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import model.Player;
import model.game.Shop;
import model.jokers.Joker;

import java.util.ArrayList;

public class JokersContainerView extends HBox {
    public JokersContainerView(Player player, ArrayList<Joker> jokers, Shop shop) {
        super();
        this.setId("player-jokers-container");
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPrefWidth(775);
        this.setMaxWidth(775);
        this.setPrefHeight(190);
        this.setSpacing(0);

        for (Joker joker : jokers) {
            JokerView jokerView = new JokerView(joker, player, shop);
            jokerView.setDiscardButton();
            this.getChildren().add(jokerView);
        }
    }
}
