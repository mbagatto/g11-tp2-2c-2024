package model.game;

import model.*;
import model.tarots.Tarot;
import model.jokers.Joker;
import model.score.Score;
import view.records.RoundRecord;

import java.util.ArrayList;
import java.util.Stack;

public class Round implements Observable, Playable, ObservableRound {
    private int number;
    private Score hands;
    private Score discards;
    private final Score scoreToBeat;
    private Shop shop;
    private Stack<PlayHand> playHands;
    private Stack<DiscardHand> discardHands;
    private TurnGenerator turnGenerator;
    private Score actualScore;
    private ArrayList<Observer> observers;
    private ArrayList<ObserverRound> observersRound;

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
        this.observersRound = new ArrayList<>();
    }

    public void playHand(Player player) {
        PlayHand playHand = this.playHands.pop();
        this.actualScore = this.actualScore.addWith(playHand.playTurn(player));
    }

    public void discardHand(Player player) {
        DiscardHand discardHand = this.discardHands.pop();
        this.actualScore = this.actualScore.addWith(discardHand.playTurn(player));
    }

    public Joker buyJoker(int index) {
        return this.shop.buyJoker(index);
    }

    public Tarot buyTarot(int i) {
        return this.shop.buyTarot(i);
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public Score getHands() {
        return this.hands;
    }

    @Override
    public Score getDiscards() {
        return this.discards;
    }

    @Override
    public Score getScoreToBeat() {
        return this.scoreToBeat;
    }

    @Override
    public Shop getShop() {
        return this.shop;
    }

    @Override
    public Score getActualScore() {
        return this.actualScore;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(); // no se cuando se utiliza realmente
        }
    }

    public RoundRecord toRoundRecord() {
        return new RoundRecord(this.number,
                               this.playHands.size(),
                                this.discardHands.size(),
                                this.scoreToBeat.toRecord(),
                                this.actualScore.toRecord());
    }

    @Override
    public void addObserverRound(ObserverRound observerRound) {
        this.observersRound.add(observerRound);
        observerRound.update(this.toRoundRecord());
    }

    @Override
    public void notifyObserversRound() {
        for (ObserverRound observerRound : this.observersRound) {
            observerRound.update(this.toRoundRecord());
        }
    }

    public boolean isGameOver() {
        return (this.hands.isLessThanOrEqualtoZero() && ! this.wonRound());
    }

    public boolean wonRound(){
        return (this.actualScore.isGreaterThanOrEqualTo(this.scoreToBeat)) ;
    }

    public boolean won(){
        return (this.number == 8 && this.wonRound());
    }

    public void subtractHand() {
        this.hands.subtractOne();
    }

    public boolean ranOutOfHands() {
        return (this.hands.isLessThanOrEqualtoZero());
    }
}
