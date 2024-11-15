package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreeOfAKindTest {
    @Test
    public void verifyAHandIsThreeOfAKind() {
        HandPattern threeOfAKind = new ThreeOfAKind();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(2, "spade"));
        cards.add(new Card(2, "diamond"));
        Hand expectedHand = new Hand(30, 3);
        Hand obtainedHand = threeOfAKind.verifyPattern(cards);
        assertTrue(expectedHand.isEqualAs(obtainedHand));
    }
}
