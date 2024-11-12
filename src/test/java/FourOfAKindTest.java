import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FourOfAKindTest {
    @Test
    public void verifyAHandIsFourOfAKind() {
        HandPattern fourOfAKind = new FourOfAKind();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(10, "heart"));
        cards.add(new Card(10, "diamond"));
        cards.add(new Card(10, "club"));
        cards.add(new Card(10, "spade"));
        Hand expectedHand = new Hand(60, 7);
        Hand obtainedHand = fourOfAKind.verifyPattern(cards);
        assertTrue(expectedHand.isEqualAs(obtainedHand));
    }
}
