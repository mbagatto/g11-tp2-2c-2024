package model;

import model.cards.*;
import model.decks.EnglishDeck;
import model.exceptions.EmptyPlayerDeckException;
import model.exceptions.NoSelectedCardsException;
import model.hands.*;
import model.jokers.DiscardBonus;
import model.jokers.Joker;
import model.score.Add;
import model.score.DoNotModify;
import model.score.Multiply;
import model.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PlayerTest {
    private EnglishDeck englishDeckMock;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        englishDeckMock = Mockito.mock(EnglishDeck.class);
        when(englishDeckMock.deal()).thenAnswer(new Answer<Card>() {
            private List<Card> cards = List.of(
                    new Spade("2", new Score(2), new Score(1)),
                    new Club("5", new Score(5), new Score(1)),
                    new Heart("2", new Score(2), new Score(1)),
                    new Spade("Rey", new Score(10), new Score(1)),
                    new Spade("Reina", new Score(10), new Score(1)),
                    new Heart("8", new Score(8), new Score(1)),
                    new Spade("4", new Score(4), new Score(1)),
                    new Club("10", new Score(10), new Score(1)),
                    new Club("9", new Score(9), new Score(1))
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
    }

    @Test
    public void test01WhenPlayingAPairItShouldGiveACertainScore() {
        // Arrange
        String nameExample = "example";
        Player player = new Player(nameExample, englishDeckMock);
        player.completeDeck();
        player.selectCard(0);
        player.selectCard(1);
        player.selectCard(4);
        player.selectCard(2);
        player.selectCard(7);
        Score expectedScore = new Score(28);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02PlayerWithoutCompleteDeckCanNotPlay() {
        String playerName = "ExampleName";
        EnglishDeck mockEnglishDeck = Mockito.mock(EnglishDeck.class);
        Player player = new Player(playerName, mockEnglishDeck);
        assertThrows(EmptyPlayerDeckException.class, player::play);
    }

    @Test
    public void test03PlayerWithoutSelectedCardsCanNotPlay() {
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        String playerName = "ExampleName";
        Player player = new Player(playerName, englishDeck);
        player.completeDeck();
        assertThrows(NoSelectedCardsException.class, player::play);
    }

    @Test
    public void test04PlayerWithValidSelectedCardsCanPlay() {
        String playerName = "ExampleName";
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        Player player = new Player(playerName, englishDeck);
        player.completeDeck();
        player.selectCard(1);
        player.selectCard(2);
        assertDoesNotThrow(player::play);
    }

    @Test
    public void test05PlayerDiscardsWithDiscardBonusAndTheMultiplierIsModifiedCorrectly() {
        // Arrange
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Holy Discard", "", new DoNotModify(), new Multiply(new Score(20)));
        player.addJoker(joker);
        player.selectCard(0);
        player.discard();
        player.selectCard(0);
        Score expectedScore = new Score(300);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test06PlayerDoesNotDiscardWithDiscardBonusAndTheMultiplierIsNotModified() {
        // Arrange
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Holy Discard", "", new DoNotModify(), new Multiply(new Score(20)));
        player.addJoker(joker);
        player.selectCard(0);
        Score expectedScore = new Score(15);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test07PlayerDiscardsTwiceWithDiscardBonusAndTheMultiplierIsModifiedCorrectly() {
        // Arrange
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Holy Discard", "", new DoNotModify(), new Multiply(new Score(20)));
        player.addJoker(joker);
        player.selectCard(0);
        player.discard();
        player.selectCard(0);
        player.discard();
        player.selectCard(0);
        Score expectedScore = new Score(6000);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test08PlayerDiscardsWithDiscardBonusAndThePointsAreModifiedCorrectly() {
        // Arrange
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Valley Ritual", "", new Add(new Score(75)), new DoNotModify());
        player.addJoker(joker);
        player.selectCard(0);
        player.discard();
        player.selectCard(0);
        Score expectedScore = new Score(90);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test09PlayerDiscardsTwiceWithDiscardBonusAndThePointsAreModifiedCorrectly() {
        // Arrange
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Valley Ritual", "", new Add(new Score(75)), new DoNotModify());
        player.addJoker(joker);
        player.selectCard(0);
        player.discard();
        player.selectCard(0);
        player.discard();
        player.selectCard(0);
        Score expectedScore = new Score(165);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test10PlayerDiscardsTwiceWithDiscardBonusAndThePointsAreNotModified() {
        // Arrange
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Valley Ritual", "", new Add(new Score(75)), new DoNotModify());
        player.addJoker(joker);
        player.selectCard(0);
        Score expectedScore = new Score(15);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}
