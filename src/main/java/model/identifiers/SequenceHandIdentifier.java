package model.identifiers;

import model.cards.Card;
import model.hands.Hand;

import java.util.ArrayList;

public abstract class SequenceHandIdentifier implements HandIdentifier {
    protected HandIdentifier next;
    protected SequenceChecker checker;

    public SequenceHandIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new SequenceChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (cards.size() >= 5) {
            return identifyHand(cards);
        }
        return next.identify(cards);
    }

    protected abstract Hand identifyHand(ArrayList<Card> cards);
}
