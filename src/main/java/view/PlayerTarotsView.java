package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.tarots.Tarot;

public class PlayerTarotsView extends VBox {
    private Player player;

    public PlayerTarotsView(Player player) {
        super();
        this.player = player;
        this.setLayoutX(1300);
        this.setLayoutY(60);
        this.setSpacing(5);

        HBox tarotsContainer = new HBox();
        tarotsContainer.setId("player-tarots");
        tarotsContainer.setAlignment(Pos.CENTER_LEFT);
        tarotsContainer.setPrefWidth(325);
        tarotsContainer.setPrefHeight(190);
        tarotsContainer.setSpacing(30);

        for (Tarot tarot : player.getTarots()) {
            tarotsContainer.getChildren().add(new PlayerProductView(tarot, player));
        }

        Label tarotsCount = new Label(player.getTarots().size() + "/2");
        tarotsCount.setId("player-tarot-count");

        this.getChildren().add(tarotsContainer);
        this.getChildren().add(tarotsCount);
    }

    public void addView(VBox view) {
        ((HBox) this.getChildren().getFirst()).getChildren().add(view);
    }

    public void removeProduct(VBox view) {
        ((HBox) this.getChildren().getFirst()).getChildren().remove(view);
    }

    public void updateLabel() {
        ((Label) this.getChildren().getLast()).setText(this.player.getTarots().size() + "/2");
    }

    public void changeButtons() {
        int tarotAmount = ((HBox) this.getChildren().getFirst()).getChildren().size();
        if (tarotAmount != 0) {
            HBox tarotsContainer = (HBox) this.getChildren().getFirst();
            for (int i = 0; i < tarotAmount; i++) {
                PlayerProductView playerTarotView = (PlayerProductView) tarotsContainer.getChildren().get(i);
                playerTarotView.changeButton(tarotsContainer);
            }
        }
    }
}
