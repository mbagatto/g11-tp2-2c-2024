package model;

import model.Cards.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarotTest {
    @Test
    public void test01ATarotChangesCardMultiplierToSixCorrectly() {
        // Arrange
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForMultiplier());
        Card card = new Card(5, "heart");
        int expectedScore = new Score(30, 1).calculateScore();
        // Act
        card.applyTarot(tarot);
        int obtainedScore = card.calculateScore();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02ATarotChangesHandPointsToTenCorrectly() {
        // Arrange
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForValue());
        Card card = new Card(7, "spade");
        int expectedScore = new Score(10, 1).calculateScore();
        // Act
        card.applyTarot(tarot);
        int obtainedScore = card.calculateScore();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}
