package model;

import model.cards.Card;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.Hand;
import model.hands.TwoPair;
import model.identifiers.HandIdentifier;
import model.identifiers.TwoPairIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoPairIdentifierTest {
    @Test
    public void test01TwoPairIdentifierIdentifiesATwoPairCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new TwoPairIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart(2));
        cards.add(new Spade(2));
        cards.add(new Heart(3));
        cards.add(new Spade(3));
        Hand expectedHand = new TwoPair(cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
