package model;

import model.cards.*;
import model.hands.FourOfAKind;
import model.hands.Hand;
import model.identifiers.FourOfAKindIdentifier;
import model.identifiers.HandIdentifier;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourOfAKindIdentifierTest {
    @Test
    public void test01FourOfAKindIdentifierIdentifiesAFourOfAKindCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new FourOfAKindIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("4", new Score(4), new Score(1)));
        cards.add(new Spade("4", new Score(4), new Score(1)));
        cards.add(new Club("4", new Score(4), new Score(1)));
        cards.add(new Diamond("4", new Score(4), new Score(1)));
        Hand expectedHand = new FourOfAKind(cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
