import java.util.ArrayList;

public class Flush implements HandPattern {
    @Override
    public boolean verifyPattern(ArrayList<Card> cards) {
        Card firstCard = cards.getFirst();
        cards.removeFirst();
        for (Card card : cards) {
            if (!firstCard.hasSameSuitAs(card)) {
                return false;
            }
        }
        return true;
    }
}
