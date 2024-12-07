package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Player;
import model.game.Shop;
import model.tarots.Tarot;

public class HandlerRemoveTarot implements EventHandler<ActionEvent> {
    private Player player;
    private Tarot tarot;
    private Shop shop;
    private SoundPlayer soundPlayer;

    public HandlerRemoveTarot(Player player, Tarot tarot, Shop shop) {
        this.player = player;
        this.tarot = tarot;
        this.shop = shop;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playTarotDown();
        this.player.removeTarot(this.tarot);
        this.shop.addTarot(this.tarot);
    }
}
