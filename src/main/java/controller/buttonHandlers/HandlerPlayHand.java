package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.GameOverView;
import view.PlayerObserver;
import view.RoundObserver;
import java.util.List;

public class HandlerPlayHand implements EventHandler<ActionEvent> {

    private PlayerObserver playerObserver;
    private RoundObserver roundObserver;
    private List<Integer> indexCards;
    private HBox cardsContainer;
    private Stage stage;

    public HandlerPlayHand(PlayerObserver playerObserver, RoundObserver roundObserver, List<Integer> indexCards, Stage stage) {
        this.playerObserver = playerObserver;
        this.roundObserver = roundObserver;
        this.indexCards = indexCards;
        this.stage = stage;
    }

    public void handle(ActionEvent event) {
        if (! this.roundObserver.ranOutOfHands()) {
            this.playerObserver.selectCards(this.indexCards);
            this.roundObserver.playHand(this.playerObserver.getplayer());
            this.playerObserver.notifyObserversPlayer();
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
        this.playerObserver.selectCards(this.indexCards);
        this.roundObserver.playHand(this.playerObserver.getplayer());
        this.playerObserver.notifyObserversPlayer();
        this.indexCards.clear();
    }
}
