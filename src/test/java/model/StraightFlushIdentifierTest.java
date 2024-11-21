package model;

import model.cards.Card;
import model.cards.Heart;
import model.hands.Hand;
import model.hands.StraightFlush;
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
        cards.add(new Heart("3 de Corazones", "3", 3, 1));
        cards.add(new Heart("7 de Corazones", "7", 7, 1));
        cards.add(new Heart("5 de Corazones", "5", 5, 1));
        cards.add(new Heart("4 de Corazones", "4", 4, 1));
        cards.add(new Heart("6 de Corazones", "6", 6, 1));
        Hand expectedHand = new StraightFlush(cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
