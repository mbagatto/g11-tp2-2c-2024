package model.reader;

import model.cards.Card;

import java.util.ArrayList;

public class DataReader {
    private final String JSON_BALATRO = "/cardsInfo/balatro.json";
    EnglishCardParser cardParser;

    public DataReader() {
        cardParser = new EnglishCardParser();
    }
    public ArrayList<Card> cardsRead() {
        return cardParser.read(JSON_BALATRO);
    }
}
