package model;

import model.cards.*;

import java.util.ArrayList;
import java.util.Objects;

public class EnglishDeck {
    private ArrayList<Card> cards;
    EnglishCardCreator creator;

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
        this.creator = new EnglishCardCreator();
    }

    public void fillDeck() {
        for (int value = 2; value <= 14; value++) {
            this.cards.add(this.creator.createDiamondCard(value));
            this.cards.add(this.creator.createClubCard(value));
            this.cards.add(this.creator.createHearCard(value));
            this.cards.add(this.creator.createSpadeCard(value));
        }
    }



    public Card deal() {
        if (this.cards.isEmpty()) {
            throw new EmptyDeckException();
        }
        return (this.cards.removeLast());
    }
}