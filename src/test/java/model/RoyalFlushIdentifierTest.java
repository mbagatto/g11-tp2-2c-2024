package model;

import model.cards.Card;
import model.cards.EnglishCardCreator;
import model.cards.Heart;
import model.identifiers.HandIdentifier;
import model.identifiers.RoyalFlushIdentifier;
import model.identifiers.SequenceChecker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoyalFlushIdentifierTest {
    @Test
    public void test01RoyalFlushIdentifierIdentifiesARoyalFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new RoyalFlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("10 de Corazones", "10", 10, 1));
        cards.add(new Heart("Rey de Corazones", "Rey", 10, 1));
        cards.add(new Heart("Reina de Corazones", "Reina", 10, 1));
        cards.add(new Heart("Jota de Corazones", "Jota", 10, 1));
        cards.add(new Heart("As de Corazones", "As", 10, 1));
        Hand expectedHand = new Hand(100, 8, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }

//    @Test
//    public void test02RoyalFlushIdentifierIdentifiesHandCorrectly() {
//        SequenceChecker sequenceChecker = new SequenceChecker();
//        EnglishCardCreator creator = new EnglishCardCreator();
//        ArrayList<Card> baseOrder = new ArrayList<Card>();
//        baseOrder.add(creator.createHearCard("Reina de Corazones","Reina",10,1));
//        baseOrder.add(creator.createHearCard("10 de Corazones","10",10,1));
//        baseOrder.add(creator.createHearCard("Jota de Corazones","Jota",10,1));
//        baseOrder.add(creator.createHearCard("As de Corazones","As",10,1));
//        baseOrder.add(creator.createHearCard("Rey de Corazones","Rey",10,1));
//
//        ArrayList<Card> l = sequenceChecker.sortCards(baseOrder);
//
//        assertTrue(true);
//    }
}
