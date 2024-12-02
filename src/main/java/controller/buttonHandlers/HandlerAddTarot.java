package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Player;
import model.tarots.Tarot;
import view.PlayerJokersView;
import view.PlayerTarotsView;

public class HandlerAddTarot implements EventHandler<ActionEvent> {
    private Player player;
    private Tarot tarot;
    private VBox shopContainer;
    private HBox tarotContainer;
    private Pane stage;

    public HandlerAddTarot(Player player, Tarot tarot, VBox shopContainer, HBox tarotContainer, Pane stage) {
        this.player = player;
        this.tarot = tarot;
        this.shopContainer = shopContainer;
        this.tarotContainer = tarotContainer;
        this.stage = stage;
    }

    public void handle(ActionEvent event) {
        this.player.addTarot(this.tarot);
        this.shopContainer.getChildren().remove(this.tarotContainer);
        this.stage.getChildren().remove(6, 12);
        this.stage.getChildren().add(new PlayerJokersView(this.stage, this.player));
        this.stage.getChildren().add(new PlayerTarotsView(this.stage, this.player));
        System.out.println(this.stage.getChildren());
    }
}
