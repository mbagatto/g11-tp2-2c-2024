package model;

import model.cards.Card;
import model.cards.Heart;
import model.hands.Hand;
import model.hands.HighCard;
import model.identifiers.HandIdentifier;
import model.identifiers.HighCardIdentifier;
import model.identifiers.NullCardIdentifier;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighCardIdentifierTest {
    @Test
    public void test01HighCardIdentifierIdentifiesAHighCardCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new HighCardIdentifier(new NullCardIdentifier());
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("8", new Score(8), new Score(1)));
        Hand expectedHand = HighCard.getInstance();
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
