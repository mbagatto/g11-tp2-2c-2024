package model;

import model.cards.*;
import model.exceptions.CouldNotReadException;
import model.exceptions.EmptyDeckException;
import model.reader.Reader;

import java.util.ArrayList;
import java.util.Objects;

public class EnglishDeck {
    private ArrayList<Card> cards;
    Reader cardReader;

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
        this.cardReader = new Reader();
    }

    public void generateDeck() {
        try {
            this.cards.addAll(this.cardReader.readEnglishCards());
        } catch (Exception e) {
            throw new CouldNotReadException();
        }
    }

    public void fillDeck(){

        //this.cards.addAll(this.creator.generateEnglishCards());
        try {
            this.cards.addAll(this.cardReader.readEnglishCards());
        } catch (Exception e) {
            throw new CouldNotReadException();
        }
    }



    public Card deal() {
        if (this.cards.isEmpty()) {
            throw new EmptyDeckException();
        }
        return (this.cards.removeLast());
    }
}