import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightFlushTest {
    @Test
    public void verifyTwoHandsAreStraightFlush() {
        HandPattern straightFlush = new StraightFlush();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(8, "spade"));
        cards.add(new Card(9, "spade"));
        cards.add(new Card(7, "spade"));
        cards.add(new Card(5, "spade"));
        cards.add(new Card(6, "spade"));
        assertTrue(straightFlush.verifyPattern(cards));
    }
}
