package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.PlayerObserver;
import view.RoundObserver;
import java.util.List;

public class HandlerPlayHand implements EventHandler<ActionEvent> {

    private PlayerObserver playerObserver;
    private RoundObserver roundObserver;
    private List<Integer> indexCards;

    public HandlerPlayHand(PlayerObserver playerObserver, RoundObserver roundObserver, List<Integer> indexCards) {
        this.playerObserver = playerObserver;
        this.roundObserver = roundObserver;
        this.indexCards = indexCards;
    }

    public void handle(ActionEvent event) {
        this.playerObserver.selectCards(this.indexCards);
        this.roundObserver.playHand(this.playerObserver.getplayer());
        this.playerObserver.notifyObserversPlayer();
        this.indexCards.clear();
        System.out.println("desde boton playHand: " + this.indexCards.toString());
    }
}
