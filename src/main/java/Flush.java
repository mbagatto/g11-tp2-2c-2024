import java.util.ArrayList;

public class Flush implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        boolean patternFound = true;
        Card firstCard = cards.getFirst();
        Card removedCard = cards.removeFirst();
        for (Card card : cards) {
            if (!firstCard.hasSameSuitAs(card)) {
                patternFound = false;
            }
        }
        cards.add(removedCard);
        if (patternFound) {
            return this.findCards(cards);
        }
        return null;
    }

    private Hand findCards(ArrayList<Card> cards){
        Hand hand = new Hand(35, 4);
        for (Card card : cards) {
            hand.addCard(card);
        }
        return hand;
    }

}
