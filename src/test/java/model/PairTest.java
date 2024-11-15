package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PairTest {
    @Test
    public void verifyThatHandIsAPair() {
        HandPattern pair = new Pair();
        Hand expectedHand = new Hand(10, 2);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(2, "spade"));
        Hand obtainedHand = pair.verifyPattern(cards);
        assertTrue(expectedHand.isEqualAs(obtainedHand));
    }
}
