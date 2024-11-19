package model.identifiers;

import model.Hand;
import model.cards.Card;

import java.util.ArrayList;

public class RoyalFlushIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private SequenceChecker checker;

    public RoyalFlushIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new SequenceChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isRoyalFlush(cards)) {
            return new Hand(100, 8, cards);
        }
        return next.identify(cards);
    }

    private boolean isRoyalFlush(ArrayList<Card> cards) {
        return checker.isRoyalFlush(cards);
    }
}
