package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.StraightFlush;
import java.util.ArrayList;

public class StraightFlushIdentifier extends SequenceHandIdentifier {
    public StraightFlushIdentifier(HandIdentifier next) {
        super(next);
    }

    @Override
    protected Hand identifyHand(ArrayList<Card> cards) {
        if (checker.isStraightFlush(cards)) {
            return StraightFlush.getInstance();
        }
        return next.identify(cards);
    }
}
