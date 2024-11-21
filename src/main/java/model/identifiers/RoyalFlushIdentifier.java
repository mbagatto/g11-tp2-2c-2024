package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.RoyalFlush;
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
        if (cards.size() < 5) { return next.identify(cards); }
        if (isRoyalFlush(cards)) {
            return new RoyalFlush(cards);
        }
        return next.identify(cards);
    }

    private boolean isRoyalFlush(ArrayList<Card> cards) {
        return checker.isRoyalFlush(cards);
    }
}
