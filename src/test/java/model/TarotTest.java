package model;

import model.cards.*;
import model.decks.EnglishDeck;
import model.hands.Hand;
import model.hands.HighCard;
import model.hands.Pair;
import model.hands.RoyalFlush;
import model.reader.DataReader;
import model.score.Add;
import model.score.DoNotModify;
import model.score.Score;
import model.score.Change;
import model.tarots.Tarot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TarotTest {
    private EnglishDeck englishDeckMock;
    private DataReader reader;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        reader = new DataReader();
        englishDeckMock = Mockito.mock(EnglishDeck.class);
        when(englishDeckMock.deal()).thenAnswer(new Answer<Card>() {
            private List<Card> cards = List.of(


                    new Club("10", new Score(10), new Score(1)),
                    new Club("Jota", new Score(10), new Score(1)),
                    new Club("Reina", new Score(10), new Score(1)),
                    new Club("Rey", new Score(10), new Score(1)),
                    new Club("As", new Score(10), new Score(1)),

                    new Spade("10", new Score(10), new Score(1)),
                    new Spade("Jota", new Score(10), new Score(1)),
                    new Spade("Reina", new Score(10), new Score(1)),
                    new Spade("Rey", new Score(10), new Score(1)),
                    new Spade("As", new Score(10), new Score(1)),

                    new Diamond("10", new Score(10), new Score(1)),
                    new Diamond("Jota", new Score(10), new Score(1)),
                    new Diamond("Reina", new Score(10), new Score(1)),
                    new Diamond("Rey", new Score(10), new Score(1)),
                    new Diamond("As", new Score(10), new Score(1)),

                    new Club("9", new Score(9), new Score(1)),
                    new Spade("9", new Score(9), new Score(1)),
                    new Diamond("9", new Score(9), new Score(1)),

                    new Spade("2", new Score(2), new Score(1)),
                    new Heart("2", new Score(2), new Score(1)),

                    new Club("8", new Score(3), new Score(1)),
                    new Heart("8", new Score(3), new Score(1)),
                    new Spade("8", new Score(3), new Score(1)),

                    new Club("7", new Score(7), new Score(1)),
                    new Spade("7", new Score(7), new Score(1)),
                    new Diamond("7", new Score(7), new Score(1)),
                    new Heart("7", new Score(7), new Score(1)),
                    new Diamond("5", new Score(5), new Score(1))


            );
            private int index = 0;

            @Override
            public Card answer(InvocationOnMock invocation) {
                if (index < cards.size()) {
                    return cards.get(index++);
                }
                return null;
            }
        });
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
        englishDeckMock.fillDeck();
        Player player = new Player("Matias", englishDeckMock);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Spade("10", new Score(10), new Score(1)));
        Hand highCard = HighCard.getInstance();
        Tarot tarot = new Tarot("The Fool", "", new Add(new Score(10)), new Add(new Score(2)));
        tarot.setTarget(highCard);
        tarot.apply(player);
        Score expectedScore = new Score(75);
        // Act
        Score obtainedScore = highCard.calculateScore(cards, new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02TheMagicianTarotChangesPairScoreCorrectly() {
        // Arrange
        englishDeckMock.fillDeck();
        Player player = new Player("Matias", englishDeckMock);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Spade("10", new Score(10), new Score(1)));
        cards.add(new Heart("10", new Score(10), new Score(1)));
        Hand pair = Pair.getInstance();
        Tarot tarot = new Tarot("The Magician", "", new Add(new Score(15)), new Add(new Score(2)));
        tarot.setTarget(pair);
        tarot.apply(player);
        Score expectedScore = new Score(180);
        // Act
        Score obtainedScore = pair.calculateScore(cards, new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03TheEmpressTarotChangesCardMultiplierCorrectly() {
        // Arrange
        englishDeckMock.fillDeck();
        Player player = new Player("Matias", englishDeckMock);
        Card card = new Spade("10", new Score(10), new Score(1));
        Tarot tarot = new Tarot("The Empress", "", new DoNotModify(), new Change(new Score(4)));
        tarot.setTarget(card);
        tarot.apply(player);
        Score expectedScore = new Score(40);
        // Act
        Score obtainedScore = card.calculateScore();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test04TheTowerTarotChangesCardPointsCorrectly() {
        // Arrange
        englishDeckMock.fillDeck();
        Player player = new Player("Matias", englishDeckMock);
        Card card = new Spade("5", new Score(5), new Score(1));
        Tarot tarot = new Tarot("The Tower", "", new Change(new Score(50)), new DoNotModify());
        tarot.setTarget(card);
        tarot.apply(player);
        Score expectedScore = new Score(50);
        // Act
        Score obtainedScore = card.calculateScore();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}
