package model;

import model.cards.Card;
import model.cards.Heart;
import model.cards.Spade;
import model.identifiers.HandIdentifier;
import model.identifiers.TwoPairIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoPairIdentifierTest {

    @Test
    public void test01TwoPairIdentifierIdentifiesATwoPairCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new TwoPairIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("2 de Corazones", "2", 2, 1));
        cards.add(new Spade("2 de Picas", "2", 2, 1));
        cards.add(new Heart("3 de Corazones", "3", 3, 1));
        cards.add(new Spade("3 de Picas", "3", 3, 1));

        Hand expectedHand = new Hand(20, 2, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }


}
