import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightTest {
    @Test
    public void verifyTwoHandsAreStraight() {
        HandPattern straight = new Straight();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(6, "spade"));
        cards.add(new Card(4, "diamond"));
        cards.add(new Card(5, "club"));
        cards.add(new Card(3, "heart"));
        assertTrue(straight.verifyPattern(cards));
    }
}
