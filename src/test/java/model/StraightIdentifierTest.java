package model;

import model.cards.*;
import model.hands.Hand;
import model.hands.Straight;
import model.identifiers.HandIdentifier;
import model.identifiers.StraightIdentifier;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightIdentifierTest {
    @Test
    public void test01StraightIdentifierIdentifiesAStraightCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new StraightIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("3",new Score(3),new Score(1)));
        cards.add(new Spade("7",new Score(7),new Score(1)));
        cards.add(new Club("5",new Score(5),new Score(1)));
        cards.add(new Diamond("4",new Score(4),new Score(1)));
        cards.add(new Heart("6",new Score(6),new Score(1)));
        Hand expectedHand = Straight.getInstance();
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
