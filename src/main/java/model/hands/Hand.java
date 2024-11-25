package model.hands;

import model.cards.Card;
import model.jokers.Joker;
import model.score.Score;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Hand {
    protected String name;
    protected Score points;
    protected Score multiplier;
    private final ArrayList<Card> cards;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return name.equals(hand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Score calculateScore(ArrayList<Joker> jokers) {
        Score points = new Score(0).addWith(this.points);
        Score multiplier = new Score(0).addWith(this.multiplier);
        for (Card card : cards) {
            points = card.addValueTo(points);
        }
        for (Joker joker : jokers) {
            points = joker.applyToPoints(points, this);
            multiplier = joker.applyToMultiplier(multiplier, this);
        }
        return points.multiplyWith(multiplier);
    }
}
