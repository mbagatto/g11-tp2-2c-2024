package model.reader;

import model.cards.Card;

import java.util.ArrayList;

public class Reader {

    private final String JSON_BALATRO = "/cardsInfo/balatro.json";
    private EnglishCardParser englishCardReader;

    public Reader() {
        this.englishCardReader = new EnglishCardParser();
    }

    public ArrayList<Card> readEnglishCards(){
        return this.englishCardReader.parser(JSON_BALATRO);
    }

}
