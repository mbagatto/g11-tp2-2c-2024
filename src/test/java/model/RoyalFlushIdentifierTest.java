package model;

import model.Cards.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoyalFlushIdentifierTest {
    @Test
    public void test01RoyalFlushIdentifierIdentifiesARoyalFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new RoyalFlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(10, "heart"));
        cards.add(new Card(13, "heart"));
        cards.add(new Card(12, "heart"));
        cards.add(new Card(11, "heart"));
        cards.add(new Card(14, "heart"));
        Hand expectedHand = new Hand(100, 8, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
