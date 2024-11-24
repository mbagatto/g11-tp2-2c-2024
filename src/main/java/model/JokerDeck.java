package model;

import model.creators.JokerCreator;
import model.jokers.Joker;
import model.reader.JokerReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class JokerDeck {
    ArrayList<Joker> jokers;
    JokerReader reader;
    JokerCreator creator;

    public JokerDeck() {
        this.jokers = new ArrayList<>();
        this.reader = new JokerReader();
        this.creator = new JokerCreator();
    }

    public void fillDeck() {

        try {

            this.jokers.addAll(this.reader.jokerReader());

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        }
    }
}
