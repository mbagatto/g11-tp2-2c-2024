package model.identifiers;

import model.cards.Card;

import java.util.ArrayList;
import java.util.Comparator;

public class SequenceChecker {
    public boolean isStraight(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        cardsCopy.sort(Comparator.comparingInt(Card::getValue));

        for (int i = 1; i < cardsCopy.size(); i++) {
            if (cardsCopy.get(i).getValue() != cardsCopy.get(i - 1).getValue() + 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isFlush(ArrayList<Card> cards) {
        Card firstCard = cards.getFirst();
        for (Card card : cards) {
            if (!firstCard.hasSameSuitAs(card)) {
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
        cardsCopy.sort(Comparator.comparingInt(Card::getValue));
        if (cards.getFirst().getValue() != 10) {
            return false;
        }
        return isStraight(cardsCopy) && isFlush(cardsCopy);
    }
}
