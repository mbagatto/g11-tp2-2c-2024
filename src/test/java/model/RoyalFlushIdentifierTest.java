package model;

import model.cards.Card;
import model.cards.Heart;
import model.hands.Hand;
import model.hands.RoyalFlush;
import model.identifiers.HandIdentifier;
import model.identifiers.RoyalFlushIdentifier;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoyalFlushIdentifierTest {
    @Test
    public void test01RoyalFlushIdentifierIdentifiesARoyalFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new RoyalFlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("10", new Score(10), new Score(1)));
        cards.add(new Heart("Rey", new Score(10), new Score(1)));
        cards.add(new Heart("Reina", new Score(10), new Score(1)));
        cards.add(new Heart("Jota", new Score(10), new Score(1)));
        cards.add(new Heart("As", new Score(10), new Score(1)));
        Hand expectedHand = new RoyalFlush(cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
