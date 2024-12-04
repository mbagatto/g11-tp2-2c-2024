package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.FinalWinScreenView;
import view.GameOverView;
import view.PlayerObserver;
import view.RoundObserver;
import java.util.List;

public class HandlerPlayHand implements EventHandler<ActionEvent> {

    private PlayerObserver playerObserver;
    private RoundObserver roundObserver;
    private List<Integer> indexCards;
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
            this.roundObserver.subtractHand();
        }
        checkLoserStatus();
    }

    public void checkLoserStatus() {
        if (this.roundObserver.isGameOver()) { // Aca se decide que pasa cuando se pierde
            GameOverView gameOverView = new GameOverView(this.stage);
        }
    }
}
