package model;

import model.cards.Card;
import model.cards.Club;
import model.cards.Heart;
import model.cards.Spade;
import model.score.Score;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void test01WhenPlayingAPairItShouldGiveACertainScore() {
        // Arrange
        EnglishDeck englishDeckMock = Mockito.mock(EnglishDeck.class);
        when(englishDeckMock.deal()).thenAnswer(new Answer<Card>() {
            private List<Card> cards = List.of(
                    new Spade(2),
                    new Club(5),
                    new Heart(2),
                    new Spade(12),
                    new Spade(11),
                    new Heart(8),
                    new Spade(4),
                    new Club(10),
                    new Club(9)
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
        String nameExample = "example";
        Player player = new Player(nameExample, englishDeckMock);
        player.completeDeck();
        player.selectCard(0);
        player.selectCard(1);
        player.selectCard(4);
        player.selectCard(2);
        player.selectCard(7);
        Score expectedScore = new Score(28, 1);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02PlayerWithoutCompleteDeckTriesPlay() {
        String playerName = "ExampleName";
        EnglishDeck mockEnglishDeck = Mockito.mock(EnglishDeck.class);
        Player player = new Player(playerName, mockEnglishDeck);
        assertThrows(EmptyPlayerDeckException.class, player::play);
    }

    @Test
    public void test03PlayerWithoutSelectedCardsTriesPlay() {
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
}
