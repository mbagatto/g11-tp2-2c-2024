package model.identifiers;

import model.hands.Hand;
import model.hands.Straight;
import model.cards.Card;
import java.util.ArrayList;

public class StraightIdentifier extends SequenceHandIdentifier {
    public StraightIdentifier(HandIdentifier next) {
        super(next);
    }

    @Override
    protected Hand identifyHand(ArrayList<Card> cards) {
        if (checker.isStraight(cards)) {
            return Straight.getInstance();
        }
        return next.identify(cards);
    }
}
