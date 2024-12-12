package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Player;
import model.game.Shop;
import model.jokers.Joker;

public class HandlerRemoveJoker implements EventHandler<ActionEvent> {
    private Player player;
    private Joker joker;
    private Shop shop;
    private SoundPlayer soundPlayer;

    public HandlerRemoveJoker(Player player, Joker joker, Shop shop) {
        this.player = player;
        this.joker = joker;
        this.shop = shop;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playJokerDown();
        this.player.removeJoker(this.joker);

        if (!this.shop.isFull()) {
            this.shop.addJoker(this.joker);
        }
    }
}
