package model.decks;

import model.tarots.Tarot;

import java.util.ArrayList;

public class TarotDeck {
    private final ArrayList<Tarot> tarots;

    public TarotDeck() {
        this.tarots = new ArrayList<>();
    }

    public int fillDeck(ArrayList<Tarot> tarots) {
        this.tarots.addAll(tarots);
        return this.tarots.size();
    }

    public Tarot findTarotByName(String name) {
        Tarot tarot = null;
        boolean found = false;
        int counter = 0;
        while(!found && counter < this.tarots.size()) {
            if (tarots.get(counter).hasName(name)) {
                found = true;
            } else {
                counter++;
            }
        }
        tarot = this.tarots.get(counter);
        return tarot;
    }
}
