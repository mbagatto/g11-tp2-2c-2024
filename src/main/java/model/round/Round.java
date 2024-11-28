package model.round;

import model.Player;
import model.tarots.Tarot;
import model.jokers.Joker;
import model.score.Score;

import java.util.Stack;

public class Round {
    private int number;
    private int hands;
    private int discards;
    private final Score scoreToBeat;
    private Store store;
    private Stack<PlayHand> playHands;
    private Stack<DiscardHand> discardHands;
    private TurnGenerator turnGenarator;
    private Score actualScore;

    public Round(int number, int hands, int discards, int scoreToBeat, Store store) {
        this.number = number;
        this.hands = hands;
        this.discards = discards;
        this.scoreToBeat = new Score(scoreToBeat);
        this.store = store;
        this.turnGenarator = new TurnGenerator();
        this.playHands = turnGenarator.GeneratePlayHands(hands);
        this.discardHands = turnGenarator.GenerateDiscardHands(discards);
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

    public boolean  wonRound(){
        return (this.actualScore.isGreaterThanOrEqualTo(this.scoreToBeat)) ;
    }

    public Joker buyJoker(int index) {
        return this.store.buyJoker(index);
    }

    public Tarot buyTarot(int i) {
        return this.store.buyTarot(i);
    }
}
