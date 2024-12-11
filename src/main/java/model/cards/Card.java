package model.cards;

import model.ObservableCard;
import model.ObserverCard;
import model.score.Score;
import model.Modifiable;
import view.dtos.EnglishCardDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Card extends Modifiable implements ObservableCard {
    protected ArrayList<ObserverCard> observers;
    protected String number;
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
        super(points, multiplier);
        this.number = number;
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

    private ArrayList<String> generateOrder() {
        return new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jota", "Reina", "Rey", "As"));
    }

    public void addObserver(ObserverCard observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (ObserverCard observer : observers) {
            observer.update(this.toDTO());
        }
    }

    public EnglishCardDTO toDTO() {
        return new EnglishCardDTO(suit, number);
    }
}
