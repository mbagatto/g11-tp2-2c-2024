package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.RoyalFlush;
import java.util.ArrayList;

public class RoyalFlushIdentifier extends SequenceHandIdentifier {

    public RoyalFlushIdentifier(HandIdentifier next) {
        super(next);
    }

    @Override
    protected Hand identifyHand(ArrayList<Card> cards) {
        if (checker.isRoyalFlush(cards)) {
            return new RoyalFlush(cards);
        }
        return next.identify(cards);
    }
}
