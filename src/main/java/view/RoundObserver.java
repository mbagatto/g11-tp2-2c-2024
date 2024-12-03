package view;

import model.ObservableRound;
import model.ObserverRound;
import model.Player;
import model.game.Round;
import view.records.RoundRecord;

import java.util.List;

public class RoundObserver implements ObservableRound {
    private Round round;
    public RoundObserver(Round round) {
        this.round = round;
    }

    @Override
    public void addObserverRound(ObserverRound observerRound) {
        this.round.addObserverRound(observerRound);
    }

    @Override
    public void notifyObserversRound() {
        this.round.notifyObserversRound();
    }

    public void playHand(Player player){
        this.round.playHand(player);
        this.notifyObserversRound();
    }

}
