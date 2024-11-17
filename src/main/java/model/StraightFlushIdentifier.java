package model;

import java.util.ArrayList;
import java.util.Comparator;

public class StraightFlushIdentifier implements HandIdentifier {
    private HandIdentifier next;

    public StraightFlushIdentifier(HandIdentifier next) {
        this.next = next;
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isStraightFlush(cards)) {
            return new Hand(100, 8, cards);
        }
        return next.identify(cards);
    }

    private boolean isStraightFlush(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        cardsCopy.sort(Comparator.comparingInt(Card::getValue));

        for (int i = 1; i < cardsCopy.size(); i++) {
            if (cardsCopy.get(i).getValue() != cardsCopy.get(i - 1).getValue() + 1) {
                return false;
            }
        }

        Card firstCard = cardsCopy.getFirst();
        for (Card card : cardsCopy) {
            if (!firstCard.hasSameSuitAs(card)) {
                return false;
            }
        }
        return true;
    }
}
