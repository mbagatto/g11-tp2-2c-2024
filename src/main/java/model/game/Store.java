package model.game;

import model.Purchaser;
import model.tarots.Tarot;
import model.cards.Card;
import model.jokers.Joker;

import java.util.ArrayList;

public class Store implements Purchaser {

    private ArrayList<Joker> jokers;
    private ArrayList<Tarot> tarots;

    private Card card;

    public Store(ArrayList<Joker> jokers, ArrayList<Tarot> tarots, Card card) {
        this.jokers = jokers;
        this.tarots = tarots;
        this.card = card;
    }

    public Joker buyJoker(int index) {
        return jokers.get(index);
    }

    public Tarot buyTarot(int index) {
        return tarots.get(index);
    }

    @Override
    public ArrayList<Joker> getJokers() {
        return this.jokers;
    }

    @Override
    public ArrayList<Tarot> getTarots() {
        return this.tarots;
    }
}
