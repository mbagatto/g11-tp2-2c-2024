package model;

import model.cards.Card;
import model.cards.Club;
import model.cards.Heart;
import model.cards.Spade;
import model.decks.EnglishDeck;
import model.reader.DataReader;
import model.reader.RoundReader;
import model.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import java.io.FileNotFoundException;
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
    }

    @Test
    public void test01ShouldLoadEnglishCardsFromJsonFileCorrectly() throws FileNotFoundException {
        // Arrange
        String playerName = "ExampleName";
        englishDeckMock.fillDeck();
        Player player = new Player(playerName, englishDeckMock);
        player.completeDeck();
        player.selectCard(1);
        Score expectedScore = new Score(10);
        // Act
        Score obtainedScore = player.play();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02RoundsMustBeCreatedCorrectlyFromJSON() {
        // Arrange
        DataReader dataReader = new DataReader();
        int expected = 8;
        // Act
        int obtained = dataReader.roundsRead().size();
        // Assert
        assertEquals(expected, obtained);
    }
}
