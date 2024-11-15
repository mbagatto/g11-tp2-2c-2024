import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightTest {
    @Test
    public void verifyAHandIsStraight() {
        HandPattern straight = new Straight();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(6, "spade"));
        cards.add(new Card(4, "diamond"));
        cards.add(new Card(5, "club"));
        cards.add(new Card(3, "heart"));
        Hand expectedHand = new Hand(30, 4);
        Hand obtainedHand = straight.verifyPattern(cards);
        assertTrue(expectedHand.isEqualAs(obtainedHand));
    }
}
