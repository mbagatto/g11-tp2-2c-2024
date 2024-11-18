package model;

import model.Cards.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PairIdentifierTest {
    @Test
    public void test01PairIdentifierIdentifiesAPairCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new PairIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(8, "heart"));
        cards.add(new Card(8, "spade"));
        Hand expectedHand = new Hand(10, 2, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
