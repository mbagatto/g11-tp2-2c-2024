package model;

import model.cards.*;
import model.decks.EnglishDeck;
import model.hands.Hand;
import model.hands.Pair;
import model.hands.RoyalFlush;
import model.jokers.Joker;
import model.reader.DataReader;
import model.round.Round;
import model.score.Score;

import model.tarots.Tarot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class RoundTest {
    private EnglishDeck englishDeckMock;
    private DataReader reader;
    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        reader = new DataReader();
        englishDeckMock = Mockito.mock(EnglishDeck.class);
        when(englishDeckMock.deal()).thenAnswer(new Answer<Card>() {
            private List<Card> cards = List.of(


                    new Club("10", new Score(10), new Score(1)),
                    new Club("Jota", new Score(10), new Score(1)),
                    new Club("Reina", new Score(10), new Score(1)),
                    new Club("Rey", new Score(10), new Score(1)),
                    new Club("As", new Score(10), new Score(1)),

                    new Spade("10", new Score(10), new Score(1)),
                    new Spade("Jota", new Score(10), new Score(1)),
                    new Spade("Reina", new Score(10), new Score(1)),
                    new Spade("Rey", new Score(10), new Score(1)),
                    new Spade("As", new Score(10), new Score(1)),

                    new Diamond("10", new Score(10), new Score(1)),
                    new Diamond("Jota", new Score(10), new Score(1)),
                    new Diamond("Reina", new Score(10), new Score(1)),
                    new Diamond("Rey", new Score(10), new Score(1)),
                    new Diamond("As", new Score(10), new Score(1)),

                    new Club("9", new Score(9), new Score(1)),
                    new Spade("9", new Score(9), new Score(1)),
                    new Diamond("9", new Score(9), new Score(1)),

                    new Spade("2", new Score(2), new Score(1)),
                    new Heart("2", new Score(2), new Score(1)),

                    new Club("8", new Score(3), new Score(1)),
                    new Heart("8", new Score(3), new Score(1)),
                    new Spade("8", new Score(3), new Score(1)),

                    new Club("7", new Score(7), new Score(1)),
                    new Spade("7", new Score(7), new Score(1)),
                    new Diamond("7", new Score(7), new Score(1)),
                    new Heart("7", new Score(7), new Score(1)),
                    new Diamond("5", new Score(5), new Score(1))


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
        Field instance = Pair.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = RoyalFlush.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void test01ShouldWinTheFirstRoundWith3HandsPlayed() {
        englishDeckMock.fillDeck();
        Player player = new Player("Me",englishDeckMock);
        player.completeDeck();
        ArrayList<Round> rounds = reader.roundsRead();
        Round roundOne = rounds.getFirst();

        //1
        player.selectCard(0);
        player.selectCard(1);
        player.selectCard(4);
        player.selectCard(3);
        player.selectCard(2);
        roundOne.playHand(player);

        //2
        player.selectCard(0);
        player.selectCard(1);
        player.selectCard(4);
        player.selectCard(3);
        player.selectCard(2);
        roundOne.playHand(player);

        //Discard 1
        player.selectCard(7);
        player.selectCard(6);
        roundOne.discardHand(player);

        //3
        player.selectCard(0);
        player.selectCard(1);
        player.selectCard(4);
        player.selectCard(3);
        player.selectCard(2);
        roundOne.playHand(player);

        boolean won = roundOne.wonRound();

        assertTrue(won);

    }

    @Test
    public void test02ShouldWinTheFirstRoundWith1HandsPlayedAndJokerPlayed() {
        englishDeckMock.fillDeck();
        Player player = new Player("Me",englishDeckMock);
        player.completeDeck();
        ArrayList<Round> rounds = reader.roundsRead();
        Round roundOne = rounds.getFirst();

        Joker buyJoker = roundOne.buyJoker(1);
        player.addJoker(buyJoker);

        //Discard 1
        player.selectCard(7);
        player.selectCard(6);
        roundOne.discardHand(player);

        //1
        player.selectCard(0);
        player.selectCard(1);
        player.selectCard(4);
        player.selectCard(3);
        player.selectCard(2);
        roundOne.playHand(player);

        boolean won = roundOne.wonRound();

        assertTrue(won);

    }

    @Test
    public void test03ShouldWinTheFirstRoundWith1HandsPlayedAndJokerPlayed() {
        englishDeckMock.fillDeck();
        Player player = new Player("Me",englishDeckMock);
        player.completeDeck();
        ArrayList<Round> rounds = reader.roundsRead();
        Round roundOne = rounds.getFirst();

        Joker buyJoker = roundOne.buyJoker(1);
        player.addJoker(buyJoker);
        Tarot buyTarot = roundOne.buyTarot(0);

        //Discard 1
        player.selectCard(7);
        player.selectCard(6);
        roundOne.discardHand(player);

        //Discard 1
        player.selectCard(7);
        player.selectCard(6);
        roundOne.discardHand(player);

        //1
        player.selectCard(0);
        player.selectCard(5);

        //apply tarot
        Hand pair = Pair.getInstance();
        buyTarot.setTarget(pair);
        buyTarot.apply();

        roundOne.playHand(player);

        boolean won = roundOne.wonRound();

        assertTrue(won);

    }

}
