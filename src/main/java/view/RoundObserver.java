package view;

import model.ObservableRound;
import model.ObserverRound;
import model.Player;
import model.game.Round;

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

    public void discardHand(Player player){
        this.round.discardHand(player);
        this.notifyObserversRound();
    }

    public void subtractHand() {
        this.round.subtractHand();
    }

    public boolean isGameOver() {
        return (this.round.isGameOver());
    }

    public boolean winRound(){
        return this.round.wonRound();
    }

    public boolean win(){
        return this.round.won();
    }

    public boolean ranOutOfHands() {
        return (this.round.ranOutOfHands());
    }

}
