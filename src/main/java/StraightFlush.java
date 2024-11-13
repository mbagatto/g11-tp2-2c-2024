import java.util.ArrayList;
import java.util.Comparator;

public class StraightFlush implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        cards.sort(Comparator.comparingInt(Card::getValue));
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getValue() != cards.get(i - 1).getValue() + 1) {
                return null;
            }
        }

        Card firstCard = cards.getFirst();
        Card removedCard = cards.removeFirst();
        for (Card card : cards) {
            if (!firstCard.hasSameSuitAs(card)) {
                cards.add(removedCard);
                return null;
            }
        }
        cards.add(removedCard);
        return this.findCards(cards);
    }

    private Hand findCards(ArrayList<Card> cards){
        Hand hand = new Hand(100, 8);
        for (Card card : cards) {
            hand.addCard(card);
        }
        return hand;
    }

}
