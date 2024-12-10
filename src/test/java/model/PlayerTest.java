package model;

import model.cards.*;
import model.decks.EnglishDeck;
import model.decks.PlayerDeck;
import model.exceptions.EmptyPlayerDeckException;
import model.exceptions.NoSelectedCardsException;
import model.hands.*;
import model.jokers.DiscardBonus;
import model.jokers.Joker;
import model.score.Add;
import model.score.DoNotModify;
import model.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private EnglishDeck englishDeck;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
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
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Cristiano Ronaldo", englishDeck);
        player.completeDeck();
        player.selectCard(twoOfSpades);
        player.selectCard(twoOfDiamonds);
        Score expectedScore = new Score(28);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02PlayerWithoutCompleteDeckCanNotPlay() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Cristiano Ronaldo", englishDeck);
        // Assert
        assertThrows(EmptyPlayerDeckException.class, player::play);
    }

    @Test
    public void test03PlayerWithoutSelectedCardsCanNotPlay() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Cristiano Ronaldo", englishDeck);
        // Act
        player.completeDeck();
        // Assert
        assertThrows(NoSelectedCardsException.class, player::play);
    }

    @Test
    public void test04PlayerWithValidSelectedCardsCanPlay() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Cristiano Ronaldo", englishDeck);
        player.completeDeck();
        // Act
        player.selectCard(twoOfSpades);
        player.selectCard(twoOfDiamonds);
        // Assert
        assertDoesNotThrow(player::play);
    }

    @Test
    public void test05PlayerDiscardsWithDiscardBonusAndTheMultiplierIsModifiedCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Holy Discard", "", new DoNotModify(), new Add(new Score(20)));
        player.addJoker(joker);
        player.selectCard(twoOfSpades);
        player.discard();
        player.selectCard(twoOfDiamonds);
        Score expectedScore = new Score(147);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test06PlayerDoesNotDiscardWithDiscardBonusAndTheMultiplierIsNotModified() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Holy Discard", "", new DoNotModify(), new Add(new Score(20)));
        player.addJoker(joker);
        player.selectCard(twoOfSpades);
        Score expectedScore = new Score(7);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test07PlayerDiscardsTwiceWithDiscardBonusAndTheMultiplierIsModifiedCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Holy Discard", "", new DoNotModify(), new Add(new Score(20)));
        player.addJoker(joker);
        player.selectCard(twoOfSpades);
        player.discard();
        player.selectCard(twoOfDiamonds);
        player.discard();
        player.selectCard(twoOfHearts);
        Score expectedScore = new Score(287);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test08PlayerDiscardsWithDiscardBonusAndThePointsAreModifiedCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Valley Ritual", "", new Add(new Score(75)), new DoNotModify());
        player.addJoker(joker);
        player.selectCard(twoOfSpades);
        player.discard();
        player.selectCard(twoOfDiamonds);
        Score expectedScore = new Score(82);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test09PlayerDiscardsTwiceWithDiscardBonusAndThePointsAreModifiedCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Valley Ritual", "", new Add(new Score(75)), new DoNotModify());
        player.addJoker(joker);
        player.selectCard(twoOfSpades);
        player.discard();
        player.selectCard(twoOfDiamonds);
        player.discard();
        player.selectCard(twoOfHearts);
        Score expectedScore = new Score(157);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test10PlayerDiscardsTwiceWithDiscardBonusAndThePointsAreNotModified() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card fiveOfDiamonds = new Diamond("5", new Score(5), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        cards.add(twoOfSpades);
        cards.add(twoOfDiamonds);
        cards.add(twoOfHearts);
        cards.add(threeOfSpades);
        cards.add(threeOfDiamonds);
        cards.add(threeOfHearts);
        cards.add(fourOfSpades);
        cards.add(fourOfDiamonds);
        cards.add(fourOfHearts);
        cards.add(fiveOfSpades);
        cards.add(fiveOfDiamonds);
        cards.add(fiveOfHearts);
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck(cards);
        Player player = new Player("Lionel Messi", englishDeck);
        player.completeDeck();
        Joker joker = new DiscardBonus("Valley Ritual", "", new Add(new Score(75)), new DoNotModify());
        player.addJoker(joker);
        player.selectCard(twoOfSpades);
        Score expectedScore = new Score(7);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}
