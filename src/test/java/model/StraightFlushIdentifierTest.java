package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightFlushIdentifierTest {
    @Test
    public void test01StraightFlushIdentifierIdentifiesAStraightFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new StraightFlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(3, "heart"));
        cards.add(new Card(7, "heart"));
        cards.add(new Card(5, "heart"));
        cards.add(new Card(4, "heart"));
        cards.add(new Card(6, "heart"));
        Hand expectedHand = new Hand(100, 8, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
