package model;

import model.Cards.Card;

import java.util.ArrayList;
import java.util.Objects;

public class Hand {
    private int points;
    private int multiplier;
    private Score score;
    private ArrayList<Card> cards;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return points == hand.points && multiplier == hand.multiplier && cards.equals(hand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, multiplier, cards);
    }

    public Hand(int points, int multiplier) {
        this.points = points;
        this.multiplier = multiplier;
        this.score = new Score(points, multiplier);
        this.cards = new ArrayList<>();
    }

    public Hand(int points, int multiplier, ArrayList<Card> cards) {
        this.points = points;
        this.multiplier = multiplier;
        this.score = new Score(points, multiplier);
        this.cards = cards;
    }



    public int calculateScore() {
        return (this.points * this.multiplier);
    }

    public boolean isEqualAs(Hand obtainedHand) {
        if (obtainedHand == null) {
            return false;
        }
        return (this.getClass().equals(obtainedHand.getClass()));
    }

    public Score calculateTotalScore(){
        for (Card card : cards) {
            card.addScoreTo(this.score);
        }
        return this.score;
    }
}
