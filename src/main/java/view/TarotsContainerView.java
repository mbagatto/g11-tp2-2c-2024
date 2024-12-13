package view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import model.Player;
import model.game.Shop;
import model.tarots.Tarot;

import java.util.ArrayList;

public class TarotsContainerView extends HBox {
    private ArrayList<TarotView> tarotViews;

    public TarotsContainerView(Player player, ArrayList<Tarot> tarots, Shop shop, boolean isRoundGameView) {
        super();
        this.setId("player-tarots-container");
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPrefWidth(315);
        this.setMaxWidth(315);
        this.setPrefHeight(190);
        this.setSpacing(30);
        this.tarotViews = new ArrayList<>();

        for (Tarot tarot : tarots) {
            TarotView tarotView = new TarotView(tarot, player, shop);
            tarotView.setDiscardAndUseButton();
            this.tarotViews.add(tarotView);

            this.getChildren().add(tarotView);
        }
        if (isRoundGameView) {
            this.setUseButtonEnabled();
        }
    }

    public void setUseButtonEnabled() {
        for (TarotView tarotView : tarotViews) {
            tarotView.setUseButtonEnabled();
        }
    }
}
