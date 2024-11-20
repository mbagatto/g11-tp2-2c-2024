package model.identifiers;

import model.hands.Hand;
import model.hands.Straight;
import model.cards.Card;
import model.score.Score;

import java.util.ArrayList;

public class StraightIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private SequenceChecker checker;

    public StraightIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new SequenceChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (cards.size() < 5) { return next.identify(cards); }
        if (isStraight(cards)) {
            return new Straight(cards);
        }
        return next.identify(cards);
    }

    private boolean isStraight(ArrayList<Card> cards) {
        return checker.isStraight(cards);
    }
}
