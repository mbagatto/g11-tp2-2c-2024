package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;


public class PlayerJokersView extends VBox {
    private Player player;

    public PlayerJokersView(Player player) {
        super();
        this.player = player;
        this.setLayoutX(500);
        this.setLayoutY(60);
        this.setSpacing(5);

        HBox jokersContainer = new HBox();
        jokersContainer.setId("player-jokers");
        jokersContainer.setAlignment(Pos.CENTER_LEFT);
        jokersContainer.setPrefWidth(775);
        jokersContainer.setPrefHeight(190);
        jokersContainer.setSpacing(30);

        for (Joker joker : player.getJokers()) {
            jokersContainer.getChildren().add(new PlayerProductView(joker, player));
        }

        Label jokersCount = new Label(player.getJokers().size() + "/5");
        jokersCount.setId("player-joker-count");

        this.getChildren().add(jokersContainer);
        this.getChildren().add(jokersCount);
    }

    public void addView(VBox view) {
        ((HBox) this.getChildren().getFirst()).getChildren().add(view);
    }

    public void removeProduct(VBox view) {
        ((HBox) this.getChildren().getFirst()).getChildren().remove(view);
    }

    public void updateLabel() {
        ((Label) this.getChildren().getLast()).setText(this.player.getJokers().size() + "/5");
    }

    public void disableButtons() {
        int jokerAmount = ((HBox) this.getChildren().getFirst()).getChildren().size();
        if (jokerAmount != 0) {
            HBox jokersContainer = (HBox) this.getChildren().getFirst();
            for (int i = 0; i < jokerAmount; i++) {
                ((PlayerProductView) jokersContainer.getChildren().get(i)).disableButton();
            }
        }
    }
}
