package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.PlayerObserver;
import view.RoundObserver;
import java.util.List;

public class HandlerDiscardHand implements EventHandler<ActionEvent> {

    private PlayerObserver playerObserver;
    private RoundObserver roundObserver;
    private List<Integer> indexCards;
    private SoundPlayer soundPlayer;

    public HandlerDiscardHand(PlayerObserver playerObserver, RoundObserver roundObserver, List<Integer> indexCards) {
        this.playerObserver = playerObserver;
        this.roundObserver = roundObserver;
        this.indexCards = indexCards;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent event) {
        this.soundPlayer.playButtonSound();
        this.playerObserver.selectCards(this.indexCards);
        this.roundObserver.discardHand(this.playerObserver.getplayer());
        this.playerObserver.notifyObserversPlayer();
        this.indexCards.clear();
    }
}
