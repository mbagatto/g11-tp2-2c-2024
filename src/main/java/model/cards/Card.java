package model.cards;

import model.score.Score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Card {
    protected String number;
    protected Score points;
    protected Score multiplier;
    protected String suit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(number, card.number) && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, suit);
    }

    public Card(String number, Score points, Score multiplier) {
        this.number = number;
        this.points = points;
        this.multiplier = multiplier;
    }

    public boolean isNumber(String key) {
        return number.equals(key);
    }

    public boolean isPreviousTo(Card card) {
        ArrayList<String> baseOrder = generateOrder();
        String thisNumber = this.number;
        String cardNumber = card.number;
        return (baseOrder.indexOf(thisNumber) == baseOrder.indexOf(cardNumber) - 1);
    }

    public boolean isSmallerThan(Card otherCard) {
        ArrayList<String> baseOrder = generateOrder();
        String thisNumber = this.number;
        String cardNumber = otherCard.number;
        return (baseOrder.indexOf(thisNumber) < baseOrder.indexOf(cardNumber));
    }

    public boolean hasSameSuitAs(Card card) {
        return this.suit.equals(card.suit);
    }

    public Score addValueTo(Score score) {
        return score.addWith(this.points);
    }

    public String toString() {
        return this.number + " of " + this.suit;
    }

    private ArrayList<String> generateOrder() {
        return new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jota", "Reina", "Rey", "As"));
    }
}
