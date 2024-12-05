package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;
import model.tarots.Tarot;
import view.PlayerJokersView;
import view.PlayerProductView;
import view.PlayerTarotsView;
import view.ShopContainer;

public class HandlerAddTarot implements EventHandler<ActionEvent> {
    private Player player;
    private Tarot tarot;
    private ShopContainer shopContainer;
    private VBox shopProductView;
    private PlayerTarotsView playerTarotsView;
    private SoundPlayer soundPlayer;

    public HandlerAddTarot(Player player, Tarot tarot, ShopContainer shopContainer, VBox shopProductView, PlayerTarotsView playerTarotsView) {
        this.player = player;
        this.tarot = tarot;
        this.shopContainer = shopContainer;
        this.shopProductView = shopProductView;
        this.playerTarotsView = playerTarotsView;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playJokerUp();
        this.player.addTarot(this.tarot);
        this.shopContainer.removeProduct(this.shopProductView);

        VBox playerTarotView = new PlayerProductView(tarot, player);
        this.playerTarotsView.addView(playerTarotView);

        Button removeButton = (Button) playerTarotView.getChildren().getLast();
        removeButton.setOnAction(new HandlerRemoveTarot(this.player, this.tarot, this.shopContainer, playerTarotView, this.playerTarotsView));

        this.playerTarotsView.updateLabel();
    }
}
