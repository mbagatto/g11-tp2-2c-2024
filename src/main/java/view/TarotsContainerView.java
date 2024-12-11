package view;

import controller.buttonHandlers.HandlerRemoveTarot;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import model.Player;
import model.game.Shop;
import model.tarots.Tarot;
import view.buttons.ButtonSpecialCard;

import java.util.ArrayList;

public class TarotsContainerView extends HBox {
    private ArrayList<TarotView> tarotViews;

    public TarotsContainerView(Player player, ArrayList<Tarot> tarots, Shop shop) {
        super();
        this.setId("player-tarots-container");
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPrefWidth(315);
        this.setMaxWidth(315);
        this.setPrefHeight(190);
        this.setSpacing(30);

        this.tarotViews = new ArrayList<>();

        for (Tarot tarot : tarots) {
            TarotView tarotView = new TarotView(tarot, player);
            tarotView.addButton(new ButtonSpecialCard(), new HandlerRemoveTarot(player, tarot, shop));
            this.getChildren().add(tarotView);
            this.tarotViews.add(tarotView);
        }
    }

    public void setUseButtons() {
        for (TarotView tarotView : tarotViews) {
            tarotView.setUseButton();
        }
    }
}
