import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullHouseTest {
    @Test
    public void verifyAHandIsFullHouse() {
        HandPattern fullHouse = new FullHouse();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(13, "heart"));
        cards.add(new Card(13, "diamond"));
        cards.add(new Card(13, "club"));
        cards.add(new Card(12, "heart"));
        cards.add(new Card(12, "spade"));
        Hand expectedHand = new Hand(40, 4);
        Hand obtainedHand = fullHouse.verifyPattern(cards);
        assertTrue(expectedHand.isEqualAs(obtainedHand));
    }
}
