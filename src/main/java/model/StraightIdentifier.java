package model;

import model.Cards.Card;

import java.util.ArrayList;
import java.util.Comparator;

public class StraightIdentifier implements HandIdentifier {
    private HandIdentifier next;

    public StraightIdentifier(HandIdentifier next) {
        this.next = next;
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isStraight(cards)) {
            return new Hand(30, 4, cards);
        }
        return next.identify(cards);
    }

    private boolean isStraight(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        cardsCopy.sort(Comparator.comparingInt(Card::getValue));

        for (int i = 1; i < cardsCopy.size(); i++) {
            if (cardsCopy.get(i).getValue() != cardsCopy.get(i - 1).getValue() + 1) {
                return false;
            }
        }
        return true;
    }
}
