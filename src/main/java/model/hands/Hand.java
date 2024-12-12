package model.hands;

import model.HandObserver;
import model.cards.Card;
import model.jokers.Joker;
import model.score.Score;
import model.score.ScoreModifier;
import model.Modifiable;
import view.dtos.HandDTO;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Hand extends Modifiable {
    protected ArrayList<HandObserver> observers;
    protected String name;

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

    public Hand(Score points, Score multiplier) {
        super(points, multiplier);
        this.observers = new ArrayList<>();
    }

    public Score calculateScore(ArrayList<Card> cards, ArrayList<Joker> jokers) {
        Score points = this.points;
        Score multiplier = this.multiplier;
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

    @Override
    public boolean applyTarot(ScoreModifier toPoints, ScoreModifier toMultiplier) {
        return super.applyTarot(toPoints, toMultiplier);
    }

    protected ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        return cards;
    }

    public HandDTO toDTO() {
        return new HandDTO(this.points.toString(), this.multiplier.toString(), this.name);
    }
}
