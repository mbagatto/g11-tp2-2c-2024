import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoublePairTest {
    @Test
    public void verifyTwoHandsAreDoublePair() {
        HandPattern doublePair = new DoublePair();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(2, "spade"));
        cards.add(new Card(3, "heart"));
        cards.add(new Card(3, "spade"));
        assertTrue(doublePair.verifyPattern(cards));
    }
}
