package model.reader;

import model.game.Round;
import model.tarots.Tarot;
import model.cards.Card;
import model.jokers.Joker;
import java.util.ArrayList;

public class DataReader {
    private final String JSON_BALATRO = "/cardsInfo/balatro.json";
    private final String JSON_TAROTS = "/cardsInfo/tarots.json";
    private final String JSON_JOKERS = "/cardsInfo/comodines.json";
    private final EnglishCardParser cardParser;
    private final RoundReader roundReader;
    private final TarotReader tarotReader;
    private final JokerReader jokerReader;

    public DataReader() {
        this.cardParser = new EnglishCardParser();
        this.roundReader = new RoundReader();
        this.jokerReader = new JokerReader();
        this.tarotReader = new TarotReader();
    }

    public ArrayList<Card> cardsRead() {
        return this.cardParser.read(JSON_BALATRO);
    }

    public ArrayList<Round> roundsRead() {
        return this.roundReader.read(JSON_BALATRO);
    }

    public ArrayList<Tarot> tarotsRead() {
        return this.tarotReader.read(JSON_TAROTS);
    }

    public ArrayList<Joker> jokersRead() {
        return this.jokerReader.read(JSON_JOKERS);
    }
}
