import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandCalculator {
    private static List<HandPattern> patterns = new ArrayList<>(Arrays.asList(
            new RoyalFlush(),
            new StraightFlush(),
            new FourOfAKind(),
            new FullHouse(),
            new Flush(),
            new Straight(),
            new ThreeOfAKind(),
            new DoublePair(),
            new Pair(),
            new HighCard()
    ));

    public Hand verifyPattern(ArrayList<Card> cards) {
        if (cards.isEmpty()) {
            return null;
        }
        for (HandPattern pattern : patterns) {
            Hand hand = pattern.verifyPattern(cards);
            if (hand != null) {
                return hand;
            }
        }
        return null;
    }
}
