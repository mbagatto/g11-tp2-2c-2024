package model.decks;

import model.Tarot;
import model.exceptions.CouldNotReadException;
import model.reader.TarotReader;

import java.util.ArrayList;

public class TarotDeck {
    private final ArrayList<Tarot> tarots;
    private final TarotReader reader;

    public TarotDeck() {
        this.tarots = new ArrayList<>();
        this.reader = new TarotReader();
    }

    public int fillDeck() {
        try {
            String path = "/cardsInfo/tarots.json";
            this.tarots.addAll(this.reader.read(path));
        } catch (CouldNotReadException e) {
            throw new RuntimeException(e);
        }
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
