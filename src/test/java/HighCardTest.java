import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighCardTest {
    @Test
    public void verifyAHandIsHighCard() {
        HandPattern highCard = new HighCard();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(10, "spade"));
        cards.add(new Card(5, "diamond"));
        Hand expectedHand = new Hand(5, 1);
        Hand obtainedHand = highCard.verifyPattern(cards);
        assertTrue(expectedHand.isEqualAs(obtainedHand));
    }
}
