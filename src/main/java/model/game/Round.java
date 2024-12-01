package model.game;

import model.Player;
import model.tarots.Tarot;
import model.jokers.Joker;
import model.score.Score;

import java.util.Stack;

public class Round {
    private int number;
    private Score hands;
    private Score discards;
    private final Score scoreToBeat;
    private Store store;
    private Stack<PlayHand> playHands;
    private Stack<DiscardHand> discardHands;
    private TurnGenerator turnGenerator;
    private Score actualScore;

    public Round(int number, Score hands, Score discards, Score scoreToBeat, Store store) {
        this.number = number;
        this.hands = hands;
        this.discards = discards;
        this.scoreToBeat = scoreToBeat;
        this.store = store;
        this.turnGenerator = new TurnGenerator();
        this.playHands = turnGenerator.generatePlayHands(hands);
        this.discardHands = turnGenerator.generateDiscardHands(discards);
        this.actualScore = new Score(0);
    }

    public void playHand(Player player) {
        PlayHand playHand = this.playHands.pop();
        this.actualScore = this.actualScore.addWith(playHand.playTurn(player));
    }

    public void discardHand(Player player) {
        DiscardHand discardHand = this.discardHands.pop();
        this.actualScore = this.actualScore.addWith(discardHand.playTurn(player));
    }

    public boolean wonRound(){
        return (this.actualScore.isGreaterThanOrEqualTo(this.scoreToBeat)) ;
    }

    public Joker buyJoker(int index) {
        return this.store.buyJoker(index);
    }

    public Tarot buyTarot(int i) {
        return this.store.buyTarot(i);
    }

    public String getNumber() {
        return this.number + "";
    }

    public String getHands() {
        return this.hands.numericValue() + "";
    }

    public String getDiscards() {
        return this.discards.numericValue() + "";
    }

    public String getScoreToBeat() {
        return this.scoreToBeat.numericValue() + "";
    }
}
