package model.identifiers;

import model.hands.Flush;
import model.hands.Hand;
import model.cards.Card;

import java.util.ArrayList;

public class FlushIdentifier extends SequenceHandIdentifier {
    public FlushIdentifier(HandIdentifier next) {
        super(next);
    }

    @Override
    protected Hand identifyHand(ArrayList<Card> cards) {
        if (checker.isFlush(cards)) {
            return Flush.getInstance();
        }
        return next.identify(cards);
    }
}
