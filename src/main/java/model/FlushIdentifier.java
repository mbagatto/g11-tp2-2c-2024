package model;

import model.Cards.Card;

import java.util.ArrayList;

public class FlushIdentifier implements HandIdentifier {
    private HandIdentifier next;

    public FlushIdentifier(HandIdentifier next) {
        this.next = next;
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isFlush(cards)) {
            return new Hand(35, 4, cards);
        }
        return next.identify(cards);
    }

    private boolean isFlush(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        boolean patternFound = true;

        Card firstCard = cardsCopy.getFirst();
        for (Card card : cardsCopy) {
            if (!firstCard.hasSameSuitAs(card)) {
                patternFound = false;
            }
        }

        return patternFound;
    }
}
