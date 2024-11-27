package model;

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
}
