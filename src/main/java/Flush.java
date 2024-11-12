import java.util.ArrayList;

public class Flush implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        boolean patternFound = true;
        Card firstCard = cards.getFirst();
        cards.removeFirst();
        for (Card card : cards) {
            if (!firstCard.hasSameSuitAs(card)) {
                patternFound = false;
            }
        }
        if (patternFound) {
            return (new Hand(35, 4));
        }
        return null;
    }
}
