package model;

import model.cards.Card;
import model.cards.Heart;
import model.cards.Spade;
import model.identifiers.HandIdentifier;
import model.identifiers.PairIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairIdentifierTest {
    @Test
    public void test01PairIdentifierIdentifiesAPairCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new PairIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart(8));
        cards.add(new Spade(8));
        Hand expectedHand = new Hand(10, 2, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
