package model;

import model.cards.Card;
import model.cards.Heart;
import model.identifiers.HandIdentifier;
import model.identifiers.StraightFlushIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightFlushIdentifierTest {
    @Test
    public void test01StraightFlushIdentifierIdentifiesAStraightFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new StraightFlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart(3));
        cards.add(new Heart(7));
        cards.add(new Heart(5));
        cards.add(new Heart(4));
        cards.add(new Heart(6));
        Hand expectedHand = new Hand(100, 8, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
