package model.hands;

import model.jokers.Joker;
import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Hand {
    protected Score score;
    private ArrayList<Card> cards;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return score.calculateScore() == hand.score.calculateScore() && cards.equals(hand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, cards);
    }

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Score calculateScore(ArrayList<Joker> jokers) {
        for (Card card : cards) {
            card.addScoreTo(this.score);
        }
        if (!jokers.isEmpty()) {
            for (Joker joker : jokers) {
                joker.applyEffect(this);
            }
        }
        return this.score;
    }

    public void addJokerScore(Score score) {
        this.score.addJokerScore(score);
    }


    public void addPoints(Score effect) {
        this.score.addPoints(effect);
    }
}
