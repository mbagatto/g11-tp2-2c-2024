package model;

import model.cards.Card;
import model.cards.Heart;
import model.hands.Hand;
import model.hands.RoyalFlush;
import model.identifiers.HandIdentifier;
import model.identifiers.RoyalFlushIdentifier;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoyalFlushIdentifierTest {
    @Test
    public void test01RoyalFlushIdentifierIdentifiesARoyalFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new RoyalFlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("10 de Corazones", "10", 10, 1));
        cards.add(new Heart("Rey de Corazones", "Rey", 10, 1));
        cards.add(new Heart("Reina de Corazones", "Reina", 10, 1));
        cards.add(new Heart("Jota de Corazones", "Jota", 10, 1));
        cards.add(new Heart("As de Corazones", "As", 10, 1));
        Hand expectedHand = new RoyalFlush(cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
