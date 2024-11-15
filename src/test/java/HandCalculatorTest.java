import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;

public class HandCalculatorTest {
    @Test
    public void patternVerifiesAPairScoreCorrectly() {
        HandCalculator handCalculator = new HandCalculator();
        ArrayList<Card> cards = new ArrayList<>();
        assertNull(handCalculator.verifyPattern(cards));
    }
}
