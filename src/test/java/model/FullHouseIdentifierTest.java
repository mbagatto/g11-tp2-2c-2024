package model;

import model.Cards.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FullHouseIdentifierTest {
    @Test
    public void test01FullHouseIdentifierIdentifiesAFullHouseCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new FullHouseIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(4, "heart"));
        cards.add(new Card(4, "spade"));
        cards.add(new Card(4, "club"));
        cards.add(new Card(10, "heart"));
        cards.add(new Card(10, "spade"));
        Hand expectedHand = new Hand(40, 4, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
