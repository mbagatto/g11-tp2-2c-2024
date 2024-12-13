package model;

import model.cards.*;
import model.decks.EnglishDeck;
import model.hands.Hand;
import model.hands.HighCard;
import model.hands.Pair;
import model.hands.RoyalFlush;
import model.score.Add;
import model.score.DoNotModify;
import model.score.Score;
import model.score.Change;
import model.tarots.Tarot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarotTest {
    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = HighCard.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = Pair.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = RoyalFlush.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void test01TheFoolTarotChangesHighCardScoreCorrectly() {
        // Arrange
        Player player = new Player("Matias", new EnglishDeck());
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Spade("10", new Score(10), new Score(1)));
        Hand highCard = HighCard.getInstance();
        Tarot tarot = new Tarot("The Fool", "", new Add(new Score(10)), new Add(new Score(2)));
        tarot.setTarget(highCard);
        tarot.apply(player, cards);
        Score expectedScore = new Score(75);
        // Act
        Score obtainedScore = highCard.calculateScore(cards, new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02TheMagicianTarotChangesPairScoreCorrectly() {
        // Arrange
        Player player = new Player("Matias", new EnglishDeck());
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Spade("10", new Score(10), new Score(1)));
        cards.add(new Heart("10", new Score(10), new Score(1)));
        Hand pair = Pair.getInstance();
        Tarot tarot = new Tarot("The Magician", "", new Add(new Score(15)), new Add(new Score(2)));
        tarot.setTarget(pair);
        tarot.apply(player, cards);
        Score expectedScore = new Score(180);
        // Act
        Score obtainedScore = pair.calculateScore(cards, new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03TheEmpressTarotChangesCardMultiplierCorrectly() {
        // Arrange
        Player player = new Player("Matias", new EnglishDeck());
        ArrayList<Card> cards = new ArrayList<>();
        Card card = new Spade("10", new Score(10), new Score(1));
        cards.add(card);
        Tarot tarot = new Tarot("The Empress", "", new DoNotModify(), new Change(new Score(4)));
        tarot.apply(player, cards);
        Score expectedScore = new Score(40);
        // Act
        Score obtainedScore = card.calculateScore();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test04TheTowerTarotChangesCardPointsCorrectly() {
        // Arrange
        Player player = new Player("Matias", new EnglishDeck());
        ArrayList<Card> cards = new ArrayList<>();
        Card card = new Spade("5", new Score(5), new Score(1));
        cards.add(card);
        Tarot tarot = new Tarot("The Tower", "", new Change(new Score(50)), new DoNotModify());
        tarot.setTarget(card);
        tarot.apply(player, cards);
        Score expectedScore = new Score(50);
        // Act
        Score obtainedScore = card.calculateScore();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}
