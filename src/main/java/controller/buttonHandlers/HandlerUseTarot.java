package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Player;
import model.tarots.Tarot;

public class HandlerUseTarot implements EventHandler<ActionEvent> {
    private Player player;
    private Tarot tarot;

    public HandlerUseTarot(Player player, Tarot tarot) {
        this.player = player;
        this.tarot = tarot;
    }

    public void handle(ActionEvent actionEvent) {
        this.player.useTarot(this.tarot);
    }
}
