import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoyalFlushTest {
    @Test
    public void verifyTwoHandsAreRoyalFlush() {
        HandPattern royalFlush = new RoyalFlush();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(13, "club"));
        cards.add(new Card(11, "club"));
        cards.add(new Card(10, "club"));
        cards.add(new Card(12, "club"));
        cards.add(new Card(14, "club"));
        assertTrue(royalFlush.verifyPattern(cards));
    }
}
