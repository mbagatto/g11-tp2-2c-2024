package model.identifiers;

import model.hands.Flush;
import model.hands.Hand;
import model.cards.Card;

import java.util.ArrayList;

public class FlushIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private SequenceChecker checker;

    public FlushIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new SequenceChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (cards.size() < 5) { return next.identify(cards); }
        if (isFlush(cards)) {
            return new Flush(cards);
        }
        return next.identify(cards);
    }

    private boolean isFlush(ArrayList<Card> cards) {
        return checker.isFlush(cards);
    }
}
