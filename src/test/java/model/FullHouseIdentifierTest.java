package model;

import model.cards.Card;
import model.cards.Club;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.FullHouse;
import model.hands.Hand;
import model.identifiers.FullHouseIdentifier;
import model.identifiers.HandIdentifier;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullHouseIdentifierTest {
    @Test
    public void test01FullHouseIdentifierIdentifiesAFullHouseCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new FullHouseIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("4", new Score(4), new Score(1)));
        cards.add(new Spade("4", new Score(4), new Score(1)));
        cards.add(new Club("4", new Score(4), new Score(1)));
        cards.add(new Heart("10", new Score(10), new Score(1)));
        cards.add(new Spade("10", new Score(10), new Score(1)));
        Hand expectedHand = FullHouse.getInstance();
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
