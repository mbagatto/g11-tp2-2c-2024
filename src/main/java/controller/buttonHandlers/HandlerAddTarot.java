package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.tarots.Tarot;

public class HandlerAddTarot implements EventHandler<ActionEvent> {
    private Player player;
    private Tarot tarot;
    private VBox shopContainer;
    private HBox tarotContainer;

    public HandlerAddTarot(Player player, Tarot tarot, VBox shopContainer, HBox tarotContainer) {
        this.player = player;
        this.tarot = tarot;
        this.shopContainer = shopContainer;
        this.tarotContainer = tarotContainer;
    }

    public void handle(ActionEvent event) {
        this.player.addTarot(this.tarot);
        this.shopContainer.getChildren().remove(this.tarotContainer);
    }
}
