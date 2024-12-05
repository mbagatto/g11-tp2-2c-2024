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
import view.PlayerProductView;
import view.PlayerTarotsView;
import view.ShopContainer;
import view.ShopProductView;

public class HandlerRemoveTarot implements EventHandler<ActionEvent> {
    private Player player;
    private Tarot tarot;
    private ShopContainer shopContainer;
    private VBox playerTarotView;
    private PlayerTarotsView playerTarotsView;
    private SoundPlayer soundPlayer;

    public HandlerRemoveTarot(Player player, Tarot tarot, ShopContainer shopContainer, VBox playerTarotView, PlayerTarotsView playerTarotsView) {
        this.player = player;
        this.tarot = tarot;
        this.shopContainer = shopContainer;
        this.playerTarotView = playerTarotView;
        this.playerTarotsView = playerTarotsView;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playTarotDown();
        this.player.removeTarot(this.tarot);
        this.playerTarotsView.removeProduct(this.playerTarotView);

        VBox shopTarotView = new ShopProductView(tarot);
        this.shopContainer.addProduct(shopTarotView);

        Button addButton = (Button) shopTarotView.getChildren().get(1);
        addButton.setOnAction(new HandlerAddTarot(this.player, this.tarot, this.shopContainer, shopTarotView, this.playerTarotsView));

        this.playerTarotsView.updateLabel();
    }
}
