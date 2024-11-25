package model;

import model.cards.Diamond;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.Straight;
import model.jokers.*;
import model.score.Add;
import model.score.DoNotModify;
import model.score.Multiply;
import model.score.Score;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokerTest {
    @Test
    public void test01ForTheScoreJokerShouldBeAppliedCorrectlyToThePointsOfAHand() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("4", new Score(4), new Score(1)));
        playerDeck.selectCard(0);
        Joker joker = new ForTheScore("Octopus Joker", new Add(new Score(100)), new DoNotModify());
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
        playerDeck.addCard(new Spade("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Heart("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Diamond("4", new Score(4), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        Joker joker = new ForTheScore("Octopus Joker", new DoNotModify(), new Multiply(new Score(4)));
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
        playerDeck.addCard(new Spade("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Diamond("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Spade("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Spade("7", new Score(7), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Joker joker = new PlayedHandBonus("Crazy Joker", new DoNotModify(), new Add(new Score(12)), new Straight(new ArrayList<>()));
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
        playerDeck.addCard(new Spade("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Diamond("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Spade("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Spade("7", new Score(7), new Score(1)));
        playerDeck.selectCard(0);
        Joker joker = new PlayedHandBonus("Crazy Joker", new DoNotModify(), new Add(new Score(12)), new Straight(new ArrayList<>()));
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
        playerDeck.addCard(new Spade("10", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
        Joker joker = new RandomActivation("Gros Michel", new DoNotModify(), new Multiply(new Score(15)), mockProbability);
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
        playerDeck.addCard(new Spade("10", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
        Joker joker = new RandomActivation("Gros Michel", new DoNotModify(), new Multiply(new Score(15)), mockProbability);
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
        jokersForJoker.add(new PlayedHandBonus("Crazy Joker", new DoNotModify(), new Add(new Score(12)), new Straight(new ArrayList<>())));
        jokersForJoker.add(new ForTheScore("Octopus Joker", new DoNotModify(), new Multiply(new Score(4))));
        jokersForJoker.add(new RandomActivation("Gros Michel", new DoNotModify(), new Multiply(new Score(15)), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", jokersForJoker);
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Diamond("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Spade("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Spade("7", new Score(7), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
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
        jokersForJoker.add(new PlayedHandBonus("Crazy Joker", new DoNotModify(), new Add(new Score(12)), new Straight(new ArrayList<>())));
        jokersForJoker.add(new ForTheScore("Octopus Joker", new DoNotModify(), new Multiply(new Score(4))));
        jokersForJoker.add(new RandomActivation("Gros Michel", new DoNotModify(), new Multiply(new Score(15)), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", jokersForJoker);
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("10", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
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
        jokersForJoker.add(new PlayedHandBonus("Crazy Joker", new DoNotModify(), new Add(new Score(12)), new Straight(new ArrayList<>())));
        jokersForJoker.add(new ForTheScore("Octopus Joker", new DoNotModify(), new Multiply(new Score(4))));
        jokersForJoker.add(new RandomActivation("Gros Michel", new DoNotModify(), new Multiply(new Score(15)), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", jokersForJoker);
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Diamond("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Spade("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Spade("7", new Score(7), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
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
        jokersForJoker.add(new PlayedHandBonus("Crazy Joker", new DoNotModify(), new Add(new Score(12)), new Straight(new ArrayList<>())));
        jokersForJoker.add(new ForTheScore("Octopus Joker", new DoNotModify(), new Multiply(new Score(4))));
        jokersForJoker.add(new RandomActivation("Gros Michel", new DoNotModify(), new Multiply(new Score(15)), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", jokersForJoker);
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("10", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
        ArrayList<Joker> jokersForDeck = new ArrayList<>();
        jokersForDeck.add(joker);
        Score expectedScore = new Score(60);
        // Act
        Score obtainedScore = playerDeck.play(jokersForDeck);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}
