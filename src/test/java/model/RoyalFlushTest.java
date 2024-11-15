package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoyalFlushTest {
    @Test
    public void verifyAHandIsRoyalFlush() {
        HandPattern royalFlush = new RoyalFlush();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(13, "club"));
        cards.add(new Card(11, "club"));
        cards.add(new Card(10, "club"));
        cards.add(new Card(12, "club"));
        cards.add(new Card(14, "club"));
        Hand expectedHand = new Hand(100, 8);
        Hand obtainedHand = royalFlush.verifyPattern(cards);
        assertTrue(expectedHand.isEqualAs(obtainedHand));
    }
}
