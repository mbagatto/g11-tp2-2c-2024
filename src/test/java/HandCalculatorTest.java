import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;

public class HandCalculatorTest {
    @Test
    public void patternVerifiesAPairScoreCorrectly() {
        HandCalculator handCalculator = new HandCalculator();
        handCalculator.setPattern(new Pair());
        ArrayList<Card> cards = new ArrayList<>();
        Hand obtainedHand = handCalculator.verifyPattern(cards);
        assertNull(obtainedHand);
    }
}
