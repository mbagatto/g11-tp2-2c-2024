package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoPairIdentifierTest {
    @Test
    public void test01TwoPairIdentifierIdentifiesATwoPairCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new TwoPairIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(2, "heart"));
        cards.add(new Card(2, "spade"));
        cards.add(new Card(3, "heart"));
        cards.add(new Card(3, "spade"));
        Hand expectedHand = new Hand(20, 2, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
