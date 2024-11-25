package model;

import model.cards.Card;
import model.cards.Heart;
import model.hands.Flush;
import model.hands.Hand;
import model.identifiers.FlushIdentifier;
import model.identifiers.HandIdentifier;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlushIdentifierTest {

    @Test
    public void test01FlushIdentifierIdentifiesAFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new FlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("2", new Score(2), new Score(1)));
        cards.add(new Heart("8", new Score(8), new Score(1)));
        cards.add(new Heart("7", new Score(7), new Score(1)));
        cards.add(new Heart("4", new Score(4), new Score(1)));
        cards.add(new Heart("10", new Score(10), new Score(1)));
        Hand expectedHand = new Flush(cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
