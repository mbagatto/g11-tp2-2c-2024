package model.identifiers;

import model.Hand;
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
        if (isFlush(cards)) {
            return new Hand(35, 4, cards);
        }
        return next.identify(cards);
    }

    private boolean isFlush(ArrayList<Card> cards) {
        return checker.isFlush(cards);
    }
}
