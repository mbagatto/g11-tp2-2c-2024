package model.game;

import model.*;
import model.score.Score;
import view.dtos.RoundDTO;
import java.util.ArrayList;
import java.util.Stack;

public class Round implements ObservableRound {
    private int number;
    private Score hands;
    private Score discards;
    private Score scoreToBeat;
    private Shop shop;
    private Stack<PlayHand> playHands;
    private Stack<DiscardHand> discardHands;
    private TurnGenerator turnGenerator;
    private Score actualScore;
    private ArrayList<RoundObserver> observers;

    public Round(int number, Score hands, Score discards, Score scoreToBeat, Shop shop) {
        this.number = number;
        this.hands = hands;
        this.discards = discards;
        this.scoreToBeat = scoreToBeat;
        this.shop = shop;
        this.turnGenerator = new TurnGenerator();
        this.playHands = turnGenerator.generatePlayHands(hands);
        this.discardHands = turnGenerator.generateDiscardHands(discards);
        this.actualScore = new Score(0);
        this.observers = new ArrayList<>();
    }

    public void playHand(Player player) {
        if (! this.ranOutOfHands()) {
            PlayHand playHand = this.playHands.pop();
            this.actualScore = this.actualScore.addWith(playHand.playTurn(player));
            this.hands = this.hands.subtractWith(new Score(1));
            this.notifyObservers();
        }
    }

    public void discardHand(Player player) {
        if (!this.ranOutOfDiscards()) {
            DiscardHand discardHand = this.discardHands.pop();
            discardHand.playTurn(player);
            this.discards = this.discards.subtractWith(new Score(1));
            this.notifyObservers();
        }
    }

    public boolean wonRound(){
        return (this.actualScore.isGreaterThanOrEqualTo(this.scoreToBeat)) ;
    }

    public boolean ranOutOfHands() {
        return (this.hands.isLessThanOrEqualtoZero());
    }

    public boolean ranOutOfDiscards() {
        return (this.discards.isLessThanOrEqualtoZero());
    }

    public void addObserver(RoundObserver observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (RoundObserver observer : observers) {
            observer.update(this.toDTO());
        }
    }

    public RoundDTO toDTO() {
        return new RoundDTO(
                Integer.toString(this.number),
                this.actualScore.toString(),
                this.scoreToBeat.toString(),
                this.hands.toString(),
                this.discards.toString(),
                this.shop
        );
    }
}
