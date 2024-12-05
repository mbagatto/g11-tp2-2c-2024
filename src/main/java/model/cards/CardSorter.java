package model.cards;

import java.util.ArrayList;

public class CardSorter {
    private final ArrayList<Card> cards;

    public CardSorter(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> sortCards() {
        ArrayList<Card> sortedCards = new ArrayList<>(this.cards);
        sortedCards.sort((o1, o2) -> {
            if (o1.isSmallerThan(o2)) {
                return -1;
            } else if (o2.isSmallerThan(o1)) {
                return 1;
            }
            return 0;
        });
        return sortedCards;
    }

    public Card findMax() {
        ArrayList<Card> sortedCards = sortCards();
        return sortedCards.getLast();
    }
}
