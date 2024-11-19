package model;

import model.cards.Card;
import model.identifiers.HandIdentifier;
import model.identifiers.StraightIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StraightIdentifierTest {
    @Test
    public void test01StraightIdentifierIdentifiesAStraightCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new StraightIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(3, "heart"));
        cards.add(new Card(7, "spade"));
        cards.add(new Card(5, "club"));
        cards.add(new Card(4, "diamond"));
        cards.add(new Card(6, "heart"));
        Hand expectedHand = new Hand(30, 4, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
