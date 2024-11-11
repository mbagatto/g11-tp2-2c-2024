import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreeOfAKindTest {
    @Test
    public void verifyTwoHandsAreThreeOfAKind() {
        HandPattern threeOfAKind = new ThreeOfAKind();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(2, "spade"));
        cards.add(new Card(2, "diamond"));
        assertTrue(threeOfAKind.verifyPattern(cards));
    }
}
