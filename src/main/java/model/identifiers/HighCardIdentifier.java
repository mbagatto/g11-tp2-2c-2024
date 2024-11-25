package model.identifiers;

import model.cards.CardSorter;
import model.hands.Hand;
import model.cards.Card;
import model.hands.HighCard;
import java.util.ArrayList;

public class HighCardIdentifier implements HandIdentifier {
    @Override
    public Hand identify(ArrayList<Card> cards) {
        return new HighCard(findMaxCard(cards));
    }

    private ArrayList<Card> findMaxCard(ArrayList<Card> cards) {
        CardSorter sorter = new CardSorter(cards);
        return sorter.findMax();
    }
}
