package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.PlayerObserver;
import view.RoundObserver;

import java.util.List;

public class HandlerPlayHand implements EventHandler<ActionEvent> {
    private PlayerObserver observer;
    private RoundObserver roundObserver;
    private List<Integer> indexCards;
    public HandlerPlayHand(PlayerObserver playerObserver, RoundObserver roundObserver, List<Integer> indexCards) {
        this.observer = playerObserver;
        this.roundObserver = roundObserver;
        this.indexCards = indexCards;
    }

    public void handle(ActionEvent event) {
        this.observer.selectCards(this.indexCards);
        this.roundObserver.playHand(this.observer.getplayer());
        this.indexCards.clear();
        System.out.println("desde boton playHand: " + this.indexCards.toString());
    }
}
