import java.util.ArrayList;

public class HandCalculator {
    private HandPattern currentPattern;
    private ArrayList<HandPattern> patterns;

    HandCalculator() {
        patterns = new ArrayList<>();
        patterns.add(new RoyalFlush());
        patterns.add(new StraightFlush());
        patterns.add(new FourOfAKind());
        patterns.add(new FullHouse());
        patterns.add(new Flush());
        patterns.add(new Straight());
        patterns.add(new ThreeOfAKind());
        patterns.add(new DoublePair());
        patterns.add(new Pair());
        patterns.add(new HighCard());
    }
    public void setPattern(HandPattern pattern) {
        this.currentPattern = pattern;
    }

    public Hand verifyPattern(ArrayList<Card> cards) {
        return (this.currentPattern.verifyPattern(cards));
    }

    public Hand findHandType(ArrayList<Card> cards) {
        Hand hand = null;
        for (HandPattern pattern : patterns) {
            hand = pattern.verifyPattern(cards);
            if(hand != null) {
                return hand;
            }
        }
        return null;
    }

}
