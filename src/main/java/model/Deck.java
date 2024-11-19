package model;

import model.specialCards.Dealable;

import java.util.ArrayList;

public abstract class Deck {
    protected ArrayList<Dealable> cards;

    public abstract void fillDeck();

    public Dealable deal() {
        if (this.cards.isEmpty()) {
            throw new EmptyDeckException();
        }
        return (this.cards.removeLast());
    }
}
