package model;

import model.cards.Card;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.Hand;
import model.hands.TwoPair;
import model.identifiers.HandIdentifier;
import model.identifiers.TwoPairIdentifier;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoPairIdentifierTest {

    @Test
    public void test01TwoPairIdentifierIdentifiesATwoPairCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new TwoPairIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("2", new Score(2), new Score(1)));
        cards.add(new Spade("2", new Score(2), new Score(1)));
        cards.add(new Heart("3", new Score(3), new Score(1)));
        cards.add(new Spade("3", new Score(3), new Score(1)));
        Hand expectedHand = TwoPair.getInstance();
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }


}
