package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.HighCard;
import java.util.ArrayList;
import java.util.Comparator;

public class HighCardIdentifier implements HandIdentifier {
    @Override
    public Hand identify(ArrayList<Card> cards) {
        return new HighCard(findHandCards(cards));
    }

    private ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        cardsCopy.sort(Comparator.comparingInt(Card::getValue));
        ArrayList<Card> result = new ArrayList<>();
        result.add(cardsCopy.getLast());
        return result;
    }
}
