import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PairTest {
    @Test
    public void verifyTwoHandsArePair() {
        HandPattern pair = new Pair();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(2, "spade"));
        assertTrue(pair.verifyPattern(cards));
    }
}
