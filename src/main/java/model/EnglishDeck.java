package model;

import model.Cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EnglishDeck {
    private ArrayList<Card> cards;
    private static List<String> suits = new ArrayList<>(Arrays.asList("heart", "diamond", "spade", "club"));

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
    }
    public void fillDeck() {
        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) {
                this.cards.add(new Card(value, suit));
            }
        }
    }
    public Card deal() {
        if (this.cards.isEmpty()) {
            throw new EmptyDeckException();
        }
        return (this.cards.removeLast());
    }
}
