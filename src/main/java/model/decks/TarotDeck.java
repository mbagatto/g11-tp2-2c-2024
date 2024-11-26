package model.decks;

import model.exceptions.CouldNotReadException;
import model.reader.TarotReader;
import model.tarots.Tarot;

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
            this.tarots.addAll(this.reader.read());
        } catch (CouldNotReadException e) {
            throw new RuntimeException(e);
        }
        return this.tarots.size();
    }
}
