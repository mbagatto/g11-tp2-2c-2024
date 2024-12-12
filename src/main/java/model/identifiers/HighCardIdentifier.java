package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.HighCard;
import java.util.ArrayList;

public class HighCardIdentifier implements HandIdentifier  {
    private HandIdentifier next;

    public HighCardIdentifier(HandIdentifier next) {
        this.next = next;
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (!cards.isEmpty()) {
            return HighCard.getInstance();
        }
        return next.identify(cards);
    }
}
