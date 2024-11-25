package model;

import model.cards.*;
import model.exceptions.EmptyDeckException;
import model.reader.EnglishCardReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class EnglishDeck {
    private ArrayList<Card> cards;
    EnglishCardReader cardReader;
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
        this.cardReader = new EnglishCardReader();
        this.cardBuilder = new EnglishCardBuilder();
    }

    public void generateDeck() {
        try {
            this.cards.addAll(this.cardReader.englishCardReader());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillDeck(){
        try {
            this.cards.addAll(this.cardReader.englishCardReader());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Card deal() {
        if (this.cards.isEmpty()) {
            throw new EmptyDeckException();
        }
        return (this.cards.removeLast());
    }
}