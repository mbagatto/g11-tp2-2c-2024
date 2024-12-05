package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;
import view.PlayerJokersView;
import view.PlayerProductView;
import view.ShopContainer;

public class HandlerAddJoker implements EventHandler<ActionEvent> {
    private Player player;
    private Joker joker;
    private ShopContainer shopContainer;
    private VBox shopProductView;
    private PlayerJokersView playerJokersView;
    private SoundPlayer soundPlayer;

    public HandlerAddJoker(Player player, Joker joker, ShopContainer shopContainer, VBox shopProductView, PlayerJokersView playerJokersView) {
        this.player = player;
        this.joker = joker;
        this.shopContainer = shopContainer;
        this.shopProductView = shopProductView;
        this.playerJokersView = playerJokersView;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playJokerUp();
        this.player.addJoker(this.joker);
        this.shopContainer.removeProduct(this.shopProductView);

        VBox playerJokerView = new PlayerProductView(joker, player);
        this.playerJokersView.addView(playerJokerView);

        Button removeButton = (Button) playerJokerView.getChildren().getLast();
        removeButton.setOnAction(new HandlerRemoveJoker(this.player, this.joker, this.shopContainer, playerJokerView, this.playerJokersView));

        this.playerJokersView.updateLabel();
    }
}
