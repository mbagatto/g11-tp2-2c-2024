package model;

import model.cards.Card;
import model.cards.Diamond;
import model.cards.Heart;
import model.cards.Spade;
import model.decks.PlayerDeck;
import model.hands.*;
import model.jokers.*;
import model.score.Add;
import model.score.DoNotModify;
import model.score.Multiply;
import model.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokerTest {
    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = HighCard.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = ThreeOfAKind.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = Straight.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void test01ForTheScoreJokerShouldBeAppliedCorrectlyToThePointsOfAHand() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        playerDeck.addCard(fourOfSpades);
        playerDeck.selectCard(fourOfSpades);
        Joker joker = new ForTheScore("Octopus Joker", "", new Add(new Score(100)), new DoNotModify());
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(joker);
        Score expectedScore = new Score(109);
        // Act
        Score obtainedScore = playerDeck.play(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02ForTheScoreJokerShouldBeAppliedCorrectlyToTheMultiplierOfAHand() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fourOfDiamonds = new Diamond("4", new Score(4), new Score(1));
        playerDeck.addCard(fourOfSpades);
        playerDeck.addCard(fourOfHearts);
        playerDeck.addCard(fourOfDiamonds);
        playerDeck.selectCard(fourOfSpades);
        playerDeck.selectCard(fourOfHearts);
        playerDeck.selectCard(fourOfDiamonds);
        Joker joker = new ForTheScore("Octopus Joker", "", new DoNotModify(), new Multiply(new Score(4)));
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(joker);
        Score expectedScore = new Score(504);
        // Act
        Score obtainedScore = playerDeck.play(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03PlayedHandBonusJokerShouldBeAppliedCorrectlyToTheMultiplierOfAStraight() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card sixOfDiamonds = new Diamond("6", new Score(6), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card sevenOfSpades = new Spade("7", new Score(7), new Score(1));
        playerDeck.addCard(fourOfSpades);
        playerDeck.addCard(sixOfDiamonds);
        playerDeck.addCard(fiveOfSpades);
        playerDeck.addCard(threeOfSpades);
        playerDeck.addCard(sevenOfSpades);
        playerDeck.selectCard(fourOfSpades);
        playerDeck.selectCard(sixOfDiamonds);
        playerDeck.selectCard(fiveOfSpades);
        playerDeck.selectCard(threeOfSpades);
        playerDeck.selectCard(sevenOfSpades);
        Hand straight = Straight.getInstance();
        Joker joker = new PlayedHandBonus("Crazy Joker", "", new DoNotModify(), new Add(new Score(12)), straight);
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(joker);
        Score expectedScore = new Score(880);
        // Act
        Score obtainedScore = playerDeck.play(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test04PlayedHandBonusJokerShouldNotBeAppliedWhenOtherHandIsPlayed() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card sixOfDiamonds = new Diamond("6", new Score(6), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card sevenOfSpades = new Spade("7", new Score(7), new Score(1));
        playerDeck.addCard(fourOfSpades);
        playerDeck.addCard(sixOfDiamonds);
        playerDeck.addCard(fiveOfSpades);
        playerDeck.addCard(threeOfSpades);
        playerDeck.addCard(sevenOfSpades);
        playerDeck.selectCard(fourOfSpades);
        Hand straight = Straight.getInstance();
        Joker joker = new PlayedHandBonus("Crazy Joker", "", new DoNotModify(), new Add(new Score(12)), straight);
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(joker);
        Score expectedScore = new Score(9);
        // Act
        Score obtainedScore = playerDeck.play(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test05RandomActivationJokerShouldBeAppliedCorrectly() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(true);
        PlayerDeck playerDeck = new PlayerDeck();
        Card tenOfSpades = new Spade("10", new Score(10), new Score(1));
        playerDeck.addCard(tenOfSpades);
        playerDeck.selectCard(tenOfSpades);
        Joker joker = new RandomActivation("Gros Michel", "", new DoNotModify(), new Multiply(new Score(15)), mockProbability);
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(joker);
        Score expectedScore = new Score(225);
        // Act
        Score obtainedScore = playerDeck.play(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test06RandomActivationJokerShouldNotBeApplied() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(false);
        PlayerDeck playerDeck = new PlayerDeck();
        Card tenOfSpades = new Spade("10", new Score(10), new Score(1));
        playerDeck.addCard(tenOfSpades);
        playerDeck.selectCard(tenOfSpades);
        Joker joker = new RandomActivation("Gros Michel", "", new DoNotModify(), new Multiply(new Score(15)), mockProbability);
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(joker);
        Score expectedScore = new Score(15);
        // Act
        Score obtainedScore = playerDeck.play(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test07CombinatedJokerShouldActivateAllOfItsJokersCorrectly() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(true);
        ArrayList<Joker> jokersForJoker = new ArrayList<>();
        Hand straight = Straight.getInstance();
        jokersForJoker.add(new PlayedHandBonus("Crazy Joker", "", new DoNotModify(), new Add(new Score(12)), straight));
        jokersForJoker.add(new ForTheScore("Octopus Joker", "", new DoNotModify(), new Multiply(new Score(4))));
        jokersForJoker.add(new RandomActivation("Gros Michel", "", new DoNotModify(), new Multiply(new Score(15)), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", "", jokersForJoker);
        PlayerDeck playerDeck = new PlayerDeck();
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card sixOfDiamonds = new Diamond("6", new Score(6), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card sevenOfSpades = new Spade("7", new Score(7), new Score(1));
        playerDeck.addCard(fourOfSpades);
        playerDeck.addCard(sixOfDiamonds);
        playerDeck.addCard(fiveOfSpades);
        playerDeck.addCard(threeOfSpades);
        playerDeck.addCard(sevenOfSpades);
        playerDeck.selectCard(fourOfSpades);
        playerDeck.selectCard(sixOfDiamonds);
        playerDeck.selectCard(fiveOfSpades);
        playerDeck.selectCard(threeOfSpades);
        playerDeck.selectCard(sevenOfSpades);
        ArrayList<Joker> jokersForDeck = new ArrayList<>();
        jokersForDeck.add(joker);
        Score expectedScore = new Score(52800);
        // Act
        Score obtainedScore = playerDeck.play(jokersForDeck);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test08CombinatedJokerShouldNotActivatePlayedHandBonusJoker() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(true);
        ArrayList<Joker> jokersForJoker = new ArrayList<>();
        Hand straight = Straight.getInstance();
        jokersForJoker.add(new PlayedHandBonus("Crazy Joker", "", new DoNotModify(), new Add(new Score(12)), straight));
        jokersForJoker.add(new ForTheScore("Octopus Joker", "", new DoNotModify(), new Multiply(new Score(4))));
        jokersForJoker.add(new RandomActivation("Gros Michel", "", new DoNotModify(), new Multiply(new Score(15)), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", "", jokersForJoker);
        PlayerDeck playerDeck = new PlayerDeck();
        Card tenOfSpades = new Spade("10", new Score(10), new Score(1));
        playerDeck.addCard(tenOfSpades);
        playerDeck.selectCard(tenOfSpades);
        ArrayList<Joker> jokersForDeck = new ArrayList<>();
        jokersForDeck.add(joker);
        Score expectedScore = new Score(900);
        // Act
        Score obtainedScore = playerDeck.play(jokersForDeck);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test09CombinatedJokerShouldNotActivateRandomActivationJoker() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(false);
        ArrayList<Joker> jokersForJoker = new ArrayList<>();
        Hand straight = Straight.getInstance();
        jokersForJoker.add(new PlayedHandBonus("Crazy Joker", "", new DoNotModify(), new Add(new Score(12)), straight));
        jokersForJoker.add(new ForTheScore("Octopus Joker", "", new DoNotModify(), new Multiply(new Score(4))));
        jokersForJoker.add(new RandomActivation("Gros Michel", "", new DoNotModify(), new Multiply(new Score(15)), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", "", jokersForJoker);
        PlayerDeck playerDeck = new PlayerDeck();
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card sixOfDiamonds = new Diamond("6", new Score(6), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card sevenOfSpades = new Spade("7", new Score(7), new Score(1));
        playerDeck.addCard(fourOfSpades);
        playerDeck.addCard(sixOfDiamonds);
        playerDeck.addCard(fiveOfSpades);
        playerDeck.addCard(threeOfSpades);
        playerDeck.addCard(sevenOfSpades);
        playerDeck.selectCard(fourOfSpades);
        playerDeck.selectCard(sixOfDiamonds);
        playerDeck.selectCard(fiveOfSpades);
        playerDeck.selectCard(threeOfSpades);
        playerDeck.selectCard(sevenOfSpades);
        ArrayList<Joker> jokersForDeck = new ArrayList<>();
        jokersForDeck.add(joker);
        Score expectedScore = new Score(3520);
        // Act
        Score obtainedScore = playerDeck.play(jokersForDeck);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test10CombinatedJokerShouldOnlyActivateForTheScoreJoker() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(false);
        ArrayList<Joker> jokersForJoker = new ArrayList<>();
        Hand straight = Straight.getInstance();
        jokersForJoker.add(new PlayedHandBonus("Crazy Joker", "", new DoNotModify(), new Add(new Score(12)), straight));
        jokersForJoker.add(new ForTheScore("Octopus Joker", "", new DoNotModify(), new Multiply(new Score(4))));
        jokersForJoker.add(new RandomActivation("Gros Michel", "", new DoNotModify(), new Multiply(new Score(15)), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", "", jokersForJoker);
        PlayerDeck playerDeck = new PlayerDeck();
        Card tenOfSpades = new Spade("10", new Score(10), new Score(1));
        playerDeck.addCard(tenOfSpades);
        playerDeck.selectCard(tenOfSpades);
        ArrayList<Joker> jokersForDeck = new ArrayList<>();
        jokersForDeck.add(joker);
        Score expectedScore = new Score(60);
        // Act
        Score obtainedScore = playerDeck.play(jokersForDeck);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test11DiscardBonusJokerShouldBeAppliedToThePointsCorrectly() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card sixOfDiamonds = new Diamond("6", new Score(6), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card sevenOfSpades = new Spade("7", new Score(7), new Score(1));
        playerDeck.addCard(fourOfSpades);
        playerDeck.addCard(sixOfDiamonds);
        playerDeck.addCard(fiveOfSpades);
        playerDeck.addCard(threeOfSpades);
        playerDeck.addCard(sevenOfSpades);
        playerDeck.selectCard(fourOfSpades);
        Joker joker = new DiscardBonus("Flag Joker", "", new Add(new Score(30)), new DoNotModify());
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(joker);
        playerDeck.discard(jokers);
        playerDeck.selectCard(sixOfDiamonds);
        Score expectedScore = new Score(41);
        // Act
        Score obtainedScore = playerDeck.play(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test12DiscardBonusJokerShouldNotBeAppliedWhenThePlayerHasZeroDiscards() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card sixOfDiamonds = new Diamond("6", new Score(6), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card sevenOfSpades = new Spade("7", new Score(7), new Score(1));
        playerDeck.addCard(fourOfSpades);
        playerDeck.addCard(sixOfDiamonds);
        playerDeck.addCard(fiveOfSpades);
        playerDeck.addCard(threeOfSpades);
        playerDeck.addCard(sevenOfSpades);
        playerDeck.selectCard(fourOfSpades);
        Joker joker = new DiscardBonus("Flag Joker", "", new Add(new Score(30)), new DoNotModify());
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(joker);
        Score expectedScore = new Score(9);
        // Act
        Score obtainedScore = playerDeck.play(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test13DiscardBonusJokerShouldBeAppliedToTheMultiplierCorrectly() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        Card fourOfSpades = new Spade("4", new Score(4), new Score(1));
        Card sixOfDiamonds = new Diamond("6", new Score(6), new Score(1));
        Card fiveOfSpades = new Spade("5", new Score(5), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card sevenOfSpades = new Spade("7", new Score(7), new Score(1));
        playerDeck.addCard(fourOfSpades);
        playerDeck.addCard(sixOfDiamonds);
        playerDeck.addCard(fiveOfSpades);
        playerDeck.addCard(threeOfSpades);
        playerDeck.addCard(sevenOfSpades);
        playerDeck.selectCard(fourOfSpades);
        Joker joker = new DiscardBonus("Mountain Eco", "", new DoNotModify(), new Multiply(new Score(10)));
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(joker);
        playerDeck.discard(jokers);
        playerDeck.selectCard(sixOfDiamonds);
        Score expectedScore = new Score(110);
        // Act
        Score obtainedScore = playerDeck.play(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}
