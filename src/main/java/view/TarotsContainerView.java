package view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import model.Player;
import model.game.Shop;
import model.tarots.Tarot;

import java.util.ArrayList;

public class TarotsContainerView extends HBox {

    public TarotsContainerView(Player player, ArrayList<Tarot> tarots, Shop shop) {
        super();
        this.setId("player-tarots-container");
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPrefWidth(315);
        this.setMaxWidth(315);
        this.setPrefHeight(190);
        this.setSpacing(30);


        for (Tarot tarot : tarots) {
            TarotView tarotView = new TarotView(tarot, player, shop);
            tarotView.setDiscardAndUseButton();
            this.getChildren().add(tarotView);
        }
    }
}
