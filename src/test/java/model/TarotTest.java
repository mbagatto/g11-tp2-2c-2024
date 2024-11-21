package model;

import model.cards.Card;
import model.cards.Heart;

import model.hands.HighCard;
import model.score.Score;

import model.specialCards.Tarot;
import model.specialCards.TarotForCard;
import model.specialCards.TarotForHand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarotTest {

    @Test
    public void test01ATarotChangesCardMultiplierToSixCorrectly() {
        // Arrange
        Tarot tarot = new TarotForCard("La Emperatriz",new Score(1,4));
        Card card = new Heart("5 de Corazones", "5", 5, 1);

        PlayerDeck Player1Deck = new PlayerDeck();
        Player1Deck.addCard(card);
        Player1Deck.selectCard(0);



        Score expectedScore = new Score(10, 5);
        // Act
        Player1Deck.applyEffectToCard(tarot,0);
        Score obtainedScore =Player1Deck.playSelectedCards(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
/*
    @Test
    public void test02ATarotChangesHandPointsToTenCorrectly() {
        // Arrange

        ArrayList<Card> cards = new ArrayList<>();
        Tarot tarot = new TarotForHand("El tonto",new Score(10,2), new HighCard(cards) );
        Card card = new Heart("5 de Corazones", "5", 5, 1);


        PlayerDeck Player1Deck = new PlayerDeck();
        Player1Deck.addCard(card);
        Player1Deck.applyEffectToHand(tarot);
        Player1Deck.selectCard(0);



        Score expectedScore = new Score(20, 3);
        // Act

        Score obtainedScore =Player1Deck.playSelectedCards(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

*/
}