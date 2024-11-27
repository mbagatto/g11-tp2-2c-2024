package model.hands;

import model.cards.Card;
import model.jokers.Joker;
import model.score.Score;
import model.score.ScoreModifier;
import model.Modifiable;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Hand implements Modifiable {
    protected String name;
    protected Score points;
    protected Score multiplier;

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

    public Score calculateScore(ArrayList<Card> cards, ArrayList<Joker> jokers) {
        Score points = new Score(0).addWith(this.points);
        Score multiplier = new Score(0).addWith(this.multiplier);
        ArrayList<Card> handCards = findHandCards(cards);
        for (Card card : handCards) {
            points = points.addWith(card.calculateScore());
        }
        for (Joker joker : jokers) {
            points = joker.applyToPoints(points, this);
            multiplier = joker.applyToMultiplier(multiplier, this);
        }
        return points.multiplyWith(multiplier);
    }

    public void applyTarot(ScoreModifier toPoints, ScoreModifier toMultiplier) {
        this.points = toPoints.modify(this.points);
        this.multiplier = toMultiplier.modify(this.multiplier);
    }

    protected ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        return cards;
    }
}
