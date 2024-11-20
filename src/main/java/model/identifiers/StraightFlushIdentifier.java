package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.StraightFlush;
import model.score.Score;

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
        if (cards.size() < 5) { return next.identify(cards); }
        if (isStraightFlush(cards)) {
            return new StraightFlush(cards);
        }
        return next.identify(cards);
    }

    private boolean isStraightFlush(ArrayList<Card> cards) {
        return checker.isStraightFlush(cards);
    }
}
