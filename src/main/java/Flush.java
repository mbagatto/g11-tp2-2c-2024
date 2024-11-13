import java.util.ArrayList;

public class Flush implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        boolean patternFound = true;
        Card firstCard = cardsCopy.getFirst();
        for (Card card : cardsCopy) {
            if (!firstCard.hasSameSuitAs(card)) {
                patternFound = false;
            }
        }
        if (patternFound) {
            return (new Hand(35, 4, cardsCopy));
        }
        return null;
    }

//    private Hand findCards(ArrayList<Card> cards){
//        Hand hand = new Hand(35, 4);
//        for (Card card : cards) {
//            hand.addCard(card);
//        }
//        return hand;
//    }

}
