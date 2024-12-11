package model.identifiers;

import model.cards.Card;
import model.cards.CardSorter;
import java.util.ArrayList;

public class SequenceChecker {
    public boolean isStraight(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        ArrayList<Card> sortedCards = this.sortCards(cardsCopy);
        Card currentCard = sortedCards.getFirst();
        for (int i = 1; i < sortedCards.size(); i++) {
            if (!currentCard.isPreviousTo(sortedCards.get(i))) {
                return false;
            }
            currentCard = sortedCards.get(i);
        }
        return true;
    }

    public boolean isFlush(ArrayList<Card> cards) {
        Card firstCard = cards.getFirst();
        for (int i = 1; i < cards.size(); i++) {
            if (!firstCard.hasSameSuitAs(cards.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraightFlush(ArrayList<Card> cards) {
        return isStraight(cards) && isFlush(cards);
    }

    public boolean isRoyalFlush(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        ArrayList<Card> sortedCards = this.sortCards(cardsCopy);
        Card firstCard = sortedCards.getFirst();
        if (!firstCard.isNumber("10")) {
            return false;
        }
        return isStraightFlush(sortedCards);
    }

    private ArrayList<Card> sortCards(ArrayList<Card> cards) {
        CardSorter sorter = new CardSorter(cards);
        return sorter.sortCards();
    }
}
