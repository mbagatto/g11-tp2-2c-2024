package model;

import model.cards.Card;
import model.cards.Heart;
import model.hands.Hand;
import model.hands.StraightFlush;
import model.identifiers.HandIdentifier;
import model.identifiers.StraightFlushIdentifier;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightFlushIdentifierTest {
    @Test
    public void test01StraightFlushIdentifierIdentifiesAStraightFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new StraightFlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("3", new Score(3), new Score(1)));
        cards.add(new Heart("7", new Score(7), new Score(1)));
        cards.add(new Heart("5", new Score(5), new Score(1)));
        cards.add(new Heart("4", new Score(4), new Score(1)));
        cards.add(new Heart("6", new Score(6), new Score(1)));
        Hand expectedHand = StraightFlush.getInstance();
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
