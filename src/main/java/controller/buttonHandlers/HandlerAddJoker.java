package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;

public class HandlerAddJoker implements EventHandler<ActionEvent> {
    private Player player;
    private Joker joker;
    private VBox shopContainer;
    private HBox jokerContainer;

    public HandlerAddJoker(Player player, Joker joker, VBox shopContainer, HBox jokerContainer) {
        this.player = player;
        this.joker = joker;
        this.shopContainer = shopContainer;
        this.jokerContainer = jokerContainer;
    }

    public void handle(ActionEvent event) {
        this.player.addJoker(this.joker);
        this.shopContainer.getChildren().remove(this.jokerContainer);
    }
}
