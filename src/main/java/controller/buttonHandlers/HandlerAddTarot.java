package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Player;
import model.game.Shop;
import model.tarots.Tarot;

public class HandlerAddTarot implements EventHandler<ActionEvent> {
    private Player player;
    private Tarot tarot;
    private Shop shop;
    private SoundPlayer soundPlayer;

    public HandlerAddTarot(Player player, Tarot tarot, Shop shop) {
        this.player = player;
        this.tarot = tarot;
        this.shop = shop;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playTarotUp();
        this.player.addTarot(this.tarot);
        this.shop.removeTarot(this.tarot);
    }
}
