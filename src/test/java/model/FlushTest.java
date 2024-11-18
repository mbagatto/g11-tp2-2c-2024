package model;

import model.Cards.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlushTest {
    @Test
    public void verifyAHandIsFlush() {
        HandPattern flush = new Flush();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(7, "heart"));
        cards.add(new Card(10, "heart"));
        cards.add(new Card(12, "heart"));
        cards.add(new Card(3, "heart"));
        Hand expectedHand = new Hand(30, 4);
        Hand obtainedHand = flush.verifyPattern(cards);
        assertTrue(expectedHand.isEqualAs(obtainedHand));
    }
}
