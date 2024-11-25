package model;

import model.creators.JokerCreator;
import model.jokers.Joker;
import model.reader.JokerReader;
import model.reader.Reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class JokerDeck {
    ArrayList<Joker> jokers;
    Reader reader;

    public JokerDeck() {
        this.jokers = new ArrayList<>();
        this.reader = new Reader();
    }

    public void fillDeck() {
        try {
           // this.jokers = this.reader.readJoker();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
