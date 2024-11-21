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
    EnglishCardCreator cardCreator;

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
        this.cardCreator = new EnglishCardCreator();
    }

    public void generateDeck() {
        try {
            this.cards.addAll(this.cardReader.englishCardReader());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillDeck(){

        //this.cards.addAll(this.creator.generateEnglishCards());
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