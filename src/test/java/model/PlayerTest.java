package model;

import model.Cards.Card;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void whenPlayingAPairItShouldGiveACertainScore(){
        EnglishDeck englishDeckMock = Mockito.mock(EnglishDeck.class);
        when(englishDeckMock.deal()).thenAnswer(new Answer<Card>() {
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
        Player player = new Player(nameExample, englishDeckMock);
        player.completeDeck();
        player.selectCard(0);
        player.selectCard(1);
        player.selectCard(4);
        player.selectCard(2);
        player.selectCard(7);
        Score scoreObtenido = player.play();
        int expectedScore = 28;
        assertEquals(scoreObtenido.calculateScore(), expectedScore);
    }
    @Test
    public void PlayerWithoutCompleteDeckTriesPlay() {
        String playerName = "ExampleName";
        EnglishDeck mockEnglishDeck = Mockito.mock(EnglishDeck.class);
        Player player = new Player(playerName, mockEnglishDeck);
        assertThrows(EmptyPlayerDeckException.class, player::play);
    }
    @Test
    public void PlayerWithoutSelectedCardsTriesPlay() {
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        String playerName = "ExampleName";
        Player player = new Player(playerName, englishDeck);
        player.completeDeck();
        assertThrows(NoSelectedCardsException.class, player::play);
    }
    @Test
    public void PlayerWithValid() {
        String playerName = "ExampleName";
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();
        Player player = new Player(playerName, englishDeck);
        player.completeDeck();
        player.selectCard(1);
        player.selectCard(2);
        assertNotNull(player.play());
    }
}
