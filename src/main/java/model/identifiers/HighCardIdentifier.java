package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.HighCard;
import java.util.ArrayList;
import java.util.Arrays;

public class HighCardIdentifier implements HandIdentifier {
    @Override
    public Hand identify(ArrayList<Card> cards) {
        return new HighCard(findMaxCard(cards));
    }

    private ArrayList<Card> findMaxCard(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        ArrayList<String> baseOrder = new ArrayList<>(Arrays.asList("As", "Rey", "Reina", "Jota", "10", "9", "8", "7", "6", "5", "4", "3", "2"));
        boolean found = false;
        ArrayList<Card> result = new ArrayList<>();

        for(String baseOrderCard : baseOrder) {
            for (Card card : cardsCopy) {
                if (card.isNumber(baseOrderCard) && !found) {
                    found = true;
                    result.add(card);
                }
            }
        }
        return result;
    }
}
