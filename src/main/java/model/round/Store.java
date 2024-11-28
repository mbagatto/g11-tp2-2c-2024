package model.round;

import model.Tarot;
import model.cards.Card;
import model.jokers.Joker;

import java.util.List;

public class Store {

    private List<Joker> jokers;

    private List<Tarot> tarots;

    private Card card;

    public Store(List<Joker> jokers, List<Tarot> tarots, Card card) {
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

}
