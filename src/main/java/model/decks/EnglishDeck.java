package model.decks;

import model.EnglishDeckObserver;
import model.ObservableEnglishDeck;
import model.cards.*;
import model.exceptions.EmptyDeckException;
import view.dtos.EnglishDeckDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class EnglishDeck implements ObservableEnglishDeck {
    private ArrayList<Card> cards;
    private ArrayList<EnglishDeckObserver> observers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnglishDeck englishDeck = (EnglishDeck) o;
        return cards.size() == englishDeck.cards.size();
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards.size());
    }

    public EnglishDeck() {
        this.cards = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void fillDeck(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }

    public Card deal() {
        if (this.cards.isEmpty()) {
            throw new EmptyDeckException();
        }
        Card dealedCard = this.cards.removeLast();
        this.notifyObservers();
        return dealedCard;
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public void addObserver(EnglishDeckObserver observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (EnglishDeckObserver observer : observers) {
            observer.update(this.toDTO());
        }
    }

    public EnglishDeckDTO toDTO() {
        return new EnglishDeckDTO(this.cards.size());
    }
}