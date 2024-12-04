package controller.buttonHandlers;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
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
            //System.out.println("desde boton playHand: " + this.indexCards.toString());
            this.roundObserver.subtractHand();
        }
        checkWinnerAndLoserStatus();
    }

    public void checkWinnerAndLoserStatus() {
        if (this.roundObserver.isGameOver()) { // Aca se decide que pasa cuando se pierde
            GameOverView finalScreen = new GameOverView(this.stage);
        }
        if (this.roundObserver.winRound()) { // Aca se debe codear que pasa cuando se gana la partida
            PauseTransition pause = new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(event -> {
                Platform.exit(); // Por ahora simplemente se cierra. Deberia pasar a la siguiente Ronda
            });
            pause.play();
        }
    }
}
