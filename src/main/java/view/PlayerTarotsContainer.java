package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.tarots.Tarot;

public class PlayerTarotsContainer extends VBox {
    public PlayerTarotsContainer(Player player) {
        super();
        this.setLayoutX(1300);
        this.setLayoutY(60);
        this.setSpacing(5);

        HBox tarotsContainer = new HBox();
        tarotsContainer.setId("player-tarots");
        tarotsContainer.setAlignment(Pos.CENTER_LEFT);
        tarotsContainer.setPrefWidth(325);
        tarotsContainer.setPrefHeight(185);
        tarotsContainer.setSpacing(30);

        for (Tarot tarot : player.getTarots()) {
            VBox tarotView = new PurchasableView(tarot);
            tarotsContainer.getChildren().add(tarotView);
        }

        Label tarotsCount = new Label(player.getTarots().size() + "/2");
        tarotsCount.setId("player-tarot-count");

        this.getChildren().add(tarotsContainer);
        this.getChildren().add(tarotsCount);
    }
}
