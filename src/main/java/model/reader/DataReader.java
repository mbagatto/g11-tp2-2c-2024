package model.reader;

import model.Round;
import model.cards.Card;

import java.util.ArrayList;

public class DataReader {
    private final String JSON_BALATRO = "/cardsInfo/balatro.json";
    EnglishCardParser cardParser;
    RoundReader roundReader;

    public DataReader() {
        this.cardParser = new EnglishCardParser();
        this.roundReader = new RoundReader();
    }

    public ArrayList<Card> cardsRead() {
        return this.cardParser.read(JSON_BALATRO);
    }

    public ArrayList<Round> roundsRead() {
        return this.roundReader.read(JSON_BALATRO);
    }
}
