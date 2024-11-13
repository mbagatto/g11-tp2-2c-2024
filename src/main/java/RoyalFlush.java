import java.util.ArrayList;
import java.util.Comparator;

public class RoyalFlush implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        cardsCopy.sort(Comparator.comparingInt(Card::getValue));
        if (cardsCopy.getFirst().getValue() != 10) {
            return null;
        }
        for (int i = 1; i < cardsCopy.size(); i++) {
            if (cardsCopy.get(i).getValue() != cardsCopy.get(i - 1).getValue() + 1) {
                return null;
            }
        }

        Card firstCard = cardsCopy.getFirst();

        for (Card card : cardsCopy) {
            if (!firstCard.hasSameSuitAs(card)) {
                return null;
            }
        }
        return new Hand(100, 8, cardsCopy);
    }

//    private Hand findCards(ArrayList<Card> cards){
//        Hand hand = new Hand(100, 8);
//        for (Card card : cards) {
//            hand.addCard(card);
//        }
//        return hand;
//    }

}
