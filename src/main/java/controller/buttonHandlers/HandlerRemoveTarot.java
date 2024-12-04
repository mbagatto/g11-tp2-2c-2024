package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.tarots.Tarot;

public class HandlerRemoveTarot implements EventHandler<ActionEvent> {
    private VBox tarotView;
    private VBox playerTarots;
    private VBox shopContainer;
    private Player player;
    private Tarot tarot;
    private Label description;
    private SoundPlayer soundPlayer;

    public HandlerRemoveTarot(VBox tarotView, VBox playerTarots, VBox shopContainer, Player player, Tarot tarot, Label description) {
        this.tarotView = tarotView;
        this.playerTarots = playerTarots;
        this.shopContainer = shopContainer;
        this.player = player;
        this.tarot = tarot;
        this.description = description;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playTarotDown();
        this.player.removeTarot(this.tarot);

        Button button = (Button) this.tarotView.getChildren().get(1);
        button.setOnAction(new HandlerAddTarot(this.tarotView, this.playerTarots, this.shopContainer, this.player, this.tarot));

        this.tarotView.getChildren().add(this.description);
        this.shopContainer.getChildren().add(this.tarotView);
        HBox tarotsContainer = (HBox) this.playerTarots.getChildren().getFirst();
        tarotsContainer.getChildren().remove(this.tarotView);
        Label tarotCount = (Label) this.playerTarots.getChildren().getLast();
        tarotCount.setText(this.player.getTarots().size() + "/2");
    }
}
