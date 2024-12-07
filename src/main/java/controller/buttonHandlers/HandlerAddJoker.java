package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Player;
import model.game.Shop;
import model.jokers.Joker;

public class HandlerAddJoker implements EventHandler<ActionEvent> {
    private Player player;
    private Joker joker;
    private Shop shop;
    private SoundPlayer soundPlayer;

    public HandlerAddJoker(Player player, Joker joker, Shop shop) {
        this.player = player;
        this.joker = joker;
        this.shop = shop;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playJokerUp();
        this.player.addJoker(this.joker);
        this.shop.removeJoker(this.joker);
    }
}
