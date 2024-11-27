package model.identifiers;

import model.cards.Card;
import model.hands.Hand;
import java.util.ArrayList;

public abstract class FrequencyHandIdentifier implements HandIdentifier {
    protected HandIdentifier next;
    protected FrequencyChecker checker;

    public FrequencyHandIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new FrequencyChecker();
    }

    public Hand identify(ArrayList<Card> cards) {
        return identifyHand(cards);
    }

    protected abstract Hand identifyHand(ArrayList<Card> cards);
}
