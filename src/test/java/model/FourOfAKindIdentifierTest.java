package model;

import model.cards.Card;
import model.identifiers.FourOfAKindIdentifier;
import model.identifiers.HandIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourOfAKindIdentifierTest {
    @Test
    public void test01FourOfAKindIdentifierIdentifiesAFourOfAKindCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new FourOfAKindIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(4, "heart"));
        cards.add(new Card(4, "spade"));
        cards.add(new Card(4, "club"));
        cards.add(new Card(4, "diamond"));
        Hand expectedHand = new Hand(60, 7, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}