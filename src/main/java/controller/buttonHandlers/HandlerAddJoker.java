package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;
import view.PlayerJokersView;
import view.PlayerTarotsView;

public class HandlerAddJoker implements EventHandler<ActionEvent> {
    private Player player;
    private Joker joker;
    private VBox shopContainer;
    private HBox jokersContainer;
    private Pane stage;

    public HandlerAddJoker(Player player, Joker joker, VBox shopContainer, HBox jokersContainer, Pane stage) {
        this.player = player;
        this.joker = joker;
        this.shopContainer = shopContainer;
        this.jokersContainer = jokersContainer;
        this.stage = stage;
    }

    public void handle(ActionEvent event) {
        this.player.addJoker(this.joker);
        this.shopContainer.getChildren().remove(this.jokersContainer);
        this.stage.getChildren().remove(6, 12);
        this.stage.getChildren().add(new PlayerJokersView(this.stage, this.player));
        this.stage.getChildren().add(new PlayerTarotsView(this.stage, this.player));
        System.out.println(this.stage.getChildren());
    }
}
