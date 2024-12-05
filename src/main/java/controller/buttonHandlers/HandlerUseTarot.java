package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import model.Player;
import model.Purchasable;
import model.tarots.Tarot;
import view.PlayerProductView;

public class HandlerUseTarot implements EventHandler<ActionEvent> {
    private Tarot tarot;
    private Player player;
    private HBox tarotsContainer;
    private PlayerProductView tarotView;

    public HandlerUseTarot(Purchasable tarot, Player player, HBox tarotsContainer, PlayerProductView tarotView) {
        this.tarot = (Tarot) tarot;
        this.player = player;
        this.tarotsContainer = tarotsContainer;
        this.tarotView = tarotView;
    }

    public void handle(ActionEvent actionEvent) {
        if (this.player.useTarot(this.tarot)) {
            this.tarotsContainer.getChildren().remove(this.tarotView);
            this.player.removeTarot(this.tarot);
        }
    }
}
