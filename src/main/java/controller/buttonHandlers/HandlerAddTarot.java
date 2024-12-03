package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.tarots.Tarot;

public class HandlerAddTarot implements EventHandler<ActionEvent> {
    private VBox tarotView;
    private VBox playerTarots;
    private VBox shopContainer;
    private Player player;
    private Tarot tarot;

    public HandlerAddTarot(VBox tarotView, VBox playerTarots, VBox shopContainer, Player player, Tarot tarot) {
        this.tarotView = tarotView;
        this.playerTarots = playerTarots;
        this.shopContainer = shopContainer;
        this.player = player;
        this.tarot = tarot;
    }

    public void handle(ActionEvent event) {
        this.player.addTarot(this.tarot);

        Button button = (Button) this.tarotView.getChildren().get(1);
        Label description = (Label) this.tarotView.getChildren().removeLast();
        button.setOnAction(new HandlerRemoveTarot(this.tarotView, this.playerTarots, this.shopContainer, this.player, this.tarot, description));

        HBox tarotsContainer = (HBox) this.playerTarots.getChildren().getFirst();
        tarotsContainer.getChildren().add(this.tarotView);
        this.shopContainer.getChildren().remove(this.tarotView);
        Label tarotCount = (Label) this.playerTarots.getChildren().getLast();
        tarotCount.setText(this.player.getTarots().size() + "/2");
    }
}
