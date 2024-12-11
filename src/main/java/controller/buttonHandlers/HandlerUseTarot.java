package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Player;
import model.tarots.Tarot;

public class HandlerUseTarot implements EventHandler<ActionEvent> {
    private Player player;
    private Tarot tarot;
    private SoundPlayer soundPlayer;

    public HandlerUseTarot(Player player, Tarot tarot) {
        this.player = player;
        this.tarot = tarot;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playTarotUse();
        this.player.useTarot(this.tarot);
    }
}
