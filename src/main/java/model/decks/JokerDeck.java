package model.decks;

import model.jokers.Joker;
import java.util.ArrayList;

public class JokerDeck {
    private final ArrayList<Joker> jokers;

    public JokerDeck() {
        this.jokers = new ArrayList<>();
    }

    public void fillDeck(ArrayList<Joker> jokers) {
        this.jokers.addAll(jokers);
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
