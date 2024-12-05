package model;

import model.cards.Card;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.Hand;
import model.hands.Pair;
import model.identifiers.HandIdentifier;
import model.identifiers.PairIdentifier;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PairIdentifierTest {
    @Test
    public void test01PairIdentifierIdentifiesAPairCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new PairIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("8", new Score(8),new Score(1)));
        cards.add(new Spade("8", new Score(8),new Score(1)));
        Hand expectedHand = Pair.getInstance();
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
