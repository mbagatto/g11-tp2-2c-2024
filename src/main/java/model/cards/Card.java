package model.cards;

import model.ObservableCard;
import model.ObserverCard;
import model.score.Score;
import model.score.ScoreModifier;
import model.Modifiable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Card implements Modifiable, ObservableCard {
    protected ArrayList<ObserverCard> observers;
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
        this.observers = new ArrayList<>();
    }

    public Score calculateScore() {
        return this.points.multiplyWith(this.multiplier);
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

    public String toString() {
        return this.number + " of " + this.suit;
    }

    public void applyTarot(ScoreModifier toPoints, ScoreModifier toMultiplier) {
        this.points = toPoints.modify(this.points);
        this.multiplier = toMultiplier.modify(this.multiplier);
    }

    private ArrayList<String> generateOrder() {
        return new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jota", "Reina", "Rey", "As"));
    }

    public void attach(ObserverCard observer) {
        this.observers.add(observer);
    }

    public void detach(ObserverCard observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (ObserverCard observer : observers) {
            observer.update();
        }
    }

    public String getNumber() {
        return number;
    }

    public Score getPoints() {
        return points;
    }

    public Score getMultiplier() {
        return multiplier;
    }

    public String getSuit() {
        return suit;
    }
}
