package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighCardIdentifierTest {
    @Test
    public void test01HighCardIdentifierIdentifiesAHighCardCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new HighCardIdentifier();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(8, "heart"));
        Hand expectedHand = new Hand(5, 1, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
