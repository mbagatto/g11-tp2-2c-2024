package model;

import model.cards.Card;
import model.cards.Club;
import model.cards.Heart;
import model.cards.Spade;
import model.reader.EnglishCardReader;
import model.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ReaderTest {

    private EnglishDeck englishDeckMock;

    @BeforeEach
    public void setUp() {
        englishDeckMock = Mockito.mock(EnglishDeck.class);


        when(englishDeckMock.deal()).thenAnswer(new Answer<Card>() {
            private List<Card> cards = List.of(
                    new Spade("2 de Picas", "2", 2, 1),
                    new Club("5 de Trebol", "5", 5, 1),
                    new Heart("2 de Corazones", "2", 2, 1),
                    new Spade("12 de Picas", "12", 12, 1),
                    new Spade("11 de Picas", "11", 11, 1),
                    new Heart("8 de Corazones", "8", 8, 1),
                    new Spade("4 de Picas", "4", 4, 1),
                    new Club("10 de Trebol", "10", 10, 1),
                    new Club("9 de Trebol", "9", 9, 1)
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
    }



    @Test
    public void shouldLoadEnglishCardsFromJsonFile() throws FileNotFoundException {
        String playerName = "ExampleName";
        englishDeckMock.fillDeck();
        Player player = new Player(playerName, englishDeckMock);
        player.completeDeck();
        player.selectCard(1);
        Score score = player.play();
        Score expectedScore = new Score(10,1);
        assertEquals(score,expectedScore);
    }
}
