import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HandCalculatorTest {
    @Test
    public void verifyThatTypeOfHandReturnAPairHand() {
        HandCalculator handCalculator = new HandCalculator();
        handCalculator.setPattern(new Pair());
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(2, "spade"));
        assertTrue(handCalculator.verifyPattern(cards));
    }
}
