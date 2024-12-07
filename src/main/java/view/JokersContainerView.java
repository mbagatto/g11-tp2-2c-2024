package view;

import controller.buttonHandlers.HandlerRemoveJoker;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import model.Player;
import model.game.Shop;
import model.jokers.Joker;
import view.buttons.ButtonSpecialCard;

import java.util.ArrayList;

public class JokersContainerView extends HBox {
    public JokersContainerView(Player player, ArrayList<Joker> jokers, Shop shop) {
        super();
        this.setId("player-jokers-container");
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPrefWidth(775);
        this.setPrefHeight(190);
        this.setSpacing(30);

        for (Joker joker : jokers) {
            JokerView jokerView = new JokerView(joker, player);
            jokerView.addButton(new ButtonSpecialCard(), new HandlerRemoveJoker(player, joker, shop));
            this.getChildren().add(jokerView);
        }
    }
}
