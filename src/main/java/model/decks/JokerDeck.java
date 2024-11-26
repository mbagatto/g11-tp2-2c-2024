package model.decks;

import model.exceptions.CouldNotReadException;
import model.jokers.Joker;
import model.reader.JokerReader;
import java.util.ArrayList;

public class JokerDeck {
    private final ArrayList<Joker> jokers;
    private final JokerReader reader;

    public JokerDeck() {
        this.jokers = new ArrayList<>();
        this.reader = new JokerReader();
    }

    public int fillDeck() {
        try {
           this.jokers.addAll(this.reader.read());
        } catch (CouldNotReadException e) {
            throw new RuntimeException(e);
        }
        return this.jokers.size();
    }

    public Joker findJokerByName(String name) {
        Joker joker = null;
        boolean found = false;
        int counter = 0;
        while(!found && counter < this.jokers.size()) {
            if (jokers.get(counter).hasName(name)) {
                found = true;
            } else {
                counter++;
            }
        }
        joker = this.jokers.get(counter);
        return joker;
    }
}
