package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlushIdentifierTest {
    @Test
    public void test01FlushIdentifierIdentifiesAFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new FlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(8, "heart"));
        cards.add(new Card(7, "heart"));
        cards.add(new Card(4, "heart"));
        cards.add(new Card(10, "heart"));
        Hand expectedHand = new Hand(35, 4, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
