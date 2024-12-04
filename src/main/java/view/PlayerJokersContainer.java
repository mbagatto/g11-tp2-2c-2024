package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;

public class PlayerJokersContainer extends VBox {
    public PlayerJokersContainer(Player player) {
        super();
        this.setLayoutX(500);
        this.setLayoutY(60);
        this.setSpacing(5);

        HBox jokersContainer = new HBox();
        jokersContainer.setId("player-jokers");
        jokersContainer.setAlignment(Pos.CENTER_LEFT);
        jokersContainer.setPrefWidth(750);
        jokersContainer.setPrefHeight(190);
        jokersContainer.setSpacing(30);

        for (Joker joker : player.getJokers()) {
            VBox jokerView = new PurchasableView(joker);
            jokerView.getChildren().removeLast();
            jokersContainer.getChildren().add(jokerView);
        }

        Label jokersCount = new Label(player.getJokers().size() + "/5");
        jokersCount.setId("player-joker-count");

        this.getChildren().add(jokersContainer);
        this.getChildren().add(jokersCount);
    }
}
