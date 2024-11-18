package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreeOfAKindIdentifierTest {
    @Test
    public void test01ThreeOfAKindIdentifierIdentifiesAThreeOfAKindCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new ThreeOfAKindIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(3, "heart"));
        cards.add(new Card(3, "spade"));
        cards.add(new Card(3, "club"));
        Hand expectedHand = new Hand(30, 3, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
