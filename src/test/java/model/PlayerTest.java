package model;

import model.cards.Card;
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
        Deck deckMock = Mockito.mock(Deck.class);
        when(deckMock.deal()).thenAnswer( new Answer<Card>() {
            private List<Card> cards = List.of(
                    new Card(2,"spade"),
                    new Card(5,"club"),
                    new Card(2,"heart"),
                    new Card(12,"spade"),
                    new Card(11,"spade"),
                    new Card(8,"heart"),
                    new Card(4,"spade"),
                    new Card(10,"club"),
                    new Card(9,"club")
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
        Player player = new Player(nameExample, deckMock);
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
        Deck mockDeck = Mockito.mock(Deck.class);
        Player player = new Player(playerName, mockDeck);
        assertThrows(EmptyPlayerDeckException.class, player::play);
    }

    @Test
    public void test03PlayerWithoutSelectedCardsTriesPlay() {
        Deck deck = new Deck();
        deck.fillDeck();
        String playerName = "ExampleName";
        Player player = new Player(playerName, deck);
        player.completeDeck();
        assertThrows(NoSelectedCardsException.class, player::play);
    }
    @Test
    public void test04PlayerWithValid() {
        String playerName = "ExampleName";
        Deck deck = new Deck();
        deck.fillDeck();
        Player player = new Player(playerName, deck);
        player.completeDeck();
        player.selectCard(1);
        player.selectCard(2);
        assertNotNull(player.play());
    }
}
