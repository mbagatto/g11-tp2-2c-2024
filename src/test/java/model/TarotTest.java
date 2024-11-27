package model;

import model.cards.Card;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.Hand;
import model.hands.HighCard;
import model.hands.Pair;
import model.score.Add;
import model.score.DoNotModify;
import model.score.Score;
import model.score.Change;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarotTest {

    @Test
    public void test01TheFoolTarotChangesHighCardScoreCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Spade("10", new Score(10), new Score(1)));
        Hand highCard = HighCard.getInstance();
        Tarot tarot = new Tarot("The Fool", "", new Add(new Score(10)), new Add(new Score(2)), highCard);
        tarot.apply();
        Score expectedScore = new Score(75);
        // Act
        Score obtainedScore = highCard.calculateScore(cards, new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02TheMagicianTarotChangesPairScoreCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Spade("10", new Score(10), new Score(1)));
        cards.add(new Heart("10", new Score(10), new Score(1)));
        Hand pair = Pair.getInstance();
        Tarot tarot = new Tarot("The Magician", "", new Add(new Score(15)), new Add(new Score(2)), pair);
        tarot.apply();
        Score expectedScore = new Score(180);
        // Act
        Score obtainedScore = pair.calculateScore(cards, new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03TheEmpressTarotChangesCardMultiplierCorrectly() {
        // Arrange
        Card card = new Spade("10", new Score(10), new Score(1));
        Tarot tarot = new Tarot("The Empress", "", new DoNotModify(), new Change(new Score(4)), card);
        tarot.apply();
        Score expectedScore = new Score(40);
        // Act
        Score obtainedScore = card.calculateScore();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test04TheTowerTarotChangesCardPointsCorrectly() {
        // Arrange
        Card card = new Spade("5", new Score(5), new Score(1));
        Tarot tarot = new Tarot("The Tower", "", new Change(new Score(50)), new DoNotModify(), card);
        tarot.apply();
        Score expectedScore = new Score(50);
        // Act
        Score obtainedScore = card.calculateScore();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}
