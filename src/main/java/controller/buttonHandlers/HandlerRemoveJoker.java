package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;
import view.PlayerJokersView;
import view.ShopContainer;
import view.ShopProductView;

public class HandlerRemoveJoker implements EventHandler<ActionEvent> {
    private Player player;
    private Joker joker;
    private ShopContainer shopContainer;
    private VBox playerJokerView;
    private PlayerJokersView playerJokersView;
    private SoundPlayer soundPlayer;

    public HandlerRemoveJoker(Player player, Joker joker, ShopContainer shopContainer, VBox playerJokerView, PlayerJokersView playerJokersView) {
        this.player = player;
        this.joker = joker;
        this.shopContainer = shopContainer;
        this.playerJokerView = playerJokerView;
        this.playerJokersView = playerJokersView;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playJokerUp();
        this.player.removeJoker(this.joker);
        this.playerJokersView.removeProduct(this.playerJokerView);

        VBox shopJokerView = new ShopProductView(joker);
        this.shopContainer.addProduct(shopJokerView);

        Button addButton = (Button) shopJokerView.getChildren().get(1);
        addButton.setOnAction(new HandlerAddJoker(this.player, this.joker, this.shopContainer, shopJokerView, this.playerJokersView));

        this.playerJokersView.updateLabel();
    }
}
