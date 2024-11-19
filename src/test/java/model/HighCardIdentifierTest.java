package model;

import model.cards.Card;
import model.cards.Heart;
import model.identifiers.HandIdentifier;
import model.identifiers.HighCardIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighCardIdentifierTest {
    @Test
    public void test01HighCardIdentifierIdentifiesAHighCardCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new HighCardIdentifier();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart(8));
        Hand expectedHand = new Hand(5, 1, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
