package model.decks;

import model.cards.*;
import model.creators.EnglishCardBuilder;
import model.exceptions.EmptyDeckException;
import model.reader.DataReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class EnglishDeck {
    private ArrayList<Card> cards;
    DataReader cardReader;
    EnglishCardBuilder cardBuilder;

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
        this.cardReader = new DataReader();
        this.cardBuilder = new EnglishCardBuilder();
    }

    public void fillDeck(){
        try {
            this.cards.addAll(this.cardReader.cardsRead());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Card deal() {
        if (this.cards.isEmpty()) {
            throw new EmptyDeckException();
        }
        return (this.cards.removeLast());
    }
    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }
}