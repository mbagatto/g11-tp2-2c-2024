package model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void playerHas8CardsAfterDealing() {
        Deck deck = new Deck();
        Player player = new Player("Matias", deck);
        player.completeDeck();
        assertTrue(player.hasEnoughCards());
    }

    @Test
    public void whenPlayingAPairItShouldGiveACertainScore(){
        Deck deckMock = Mockito.mock(Deck.class);
        Player player = new Player("Matias", deckMock);
        /*
        when(deckMock.deal())
                .thenReturn(new Card(2,"spade"))
                .thenReturn(new Card(5,"club"))
                .thenReturn(new Card(2,"heart"))
                .thenReturn(new Card(12,"spade"))
                .thenReturn(new Card(11,"spade"))
                .thenReturn(new Card(8,"heart"))
                .thenReturn(new Card(4,"spade"))
                .thenReturn(new Card(10,"club"))
                .thenReturn(new Card(9,"club"));
        */
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
                return null;  // o lo que quieras devolver cuando se acaben las cartas
            }
        });
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

}
