package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.GameOverView;
import view.PlayerObserver;
import view.RoundObserver;

import java.util.List;

public class HandlerPlayHand implements EventHandler<ActionEvent> {
    private PlayerObserver observer;
    private RoundObserver roundObserver;
    private List<Integer> indexCards;
    private Stage stage;


    public HandlerPlayHand(PlayerObserver playerObserver, RoundObserver roundObserver, List<Integer> indexCards, Stage stage) {
        this.observer = playerObserver;
        this.roundObserver = roundObserver;
        this.indexCards = indexCards;
        this.stage = stage;
    }

    public void handle(ActionEvent event) {
        if (! this.roundObserver.ranOutOfHands()) {
            this.observer.selectCards(this.indexCards);
            this.roundObserver.playHand(this.observer.getplayer());
            this.observer.notifyObserversPlayer();
            this.indexCards.clear();
            System.out.println("desde boton playHand: " + this.indexCards.toString());
            this.roundObserver.subtractHand();
        }
        checkGameStatus();
    }

    public void checkGameStatus() {
        if (this.roundObserver.isGameOver()) {
            GameOverView finalScreen = new GameOverView(this.stage); // Aca se decide que pasa cuando se pierde
        }
        if (this.roundObserver.isWinner()) {
            // Aca se debe codear que pasa cuando se gana la partida
        }
    }
}
