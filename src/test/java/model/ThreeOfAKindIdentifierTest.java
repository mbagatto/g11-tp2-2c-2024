package model;

import model.cards.Card;
import model.cards.Club;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.Hand;
import model.hands.ThreeOfAKind;
import model.identifiers.HandIdentifier;
import model.identifiers.ThreeOfAKindIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeOfAKindIdentifierTest {
    @Test
    public void test01ThreeOfAKindIdentifierIdentifiesAThreeOfAKindCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new ThreeOfAKindIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart(3));
        cards.add(new Spade(3));
        cards.add(new Club(3));

        Hand expectedHand = new ThreeOfAKind(cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}
