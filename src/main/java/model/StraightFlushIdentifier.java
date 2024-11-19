package model;

import model.Cards.Card;

import java.util.ArrayList;

public class StraightFlushIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private SequenceChecker checker;

    public StraightFlushIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new SequenceChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isStraightFlush(cards)) {
            return new Hand(100, 8, cards);
        }
        return next.identify(cards);
    }

    private boolean isStraightFlush(ArrayList<Card> cards) {
        return checker.isStraightFlush(cards);
    }
}
