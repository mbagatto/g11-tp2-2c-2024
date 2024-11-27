package model;

import model.decks.EnglishDeck;
import model.decks.PlayerDeck;
import model.exceptions.EmptyPlayerDeckException;
import model.exceptions.InvalidJokerException;
import model.exceptions.InvalidTarotException;
import model.jokers.Joker;
import model.score.Score;
import java.util.ArrayList;

public class Player {
    private String name;
    private EnglishDeck englishDeck;
    private PlayerDeck playerDeck;
    private ArrayList<Joker> jokers;
    private ArrayList<Tarot> tarots;
    private int discards;


    public Player(String name, EnglishDeck englishDeck) {
        this.name = name;
        this.englishDeck = englishDeck;
        this.playerDeck = new PlayerDeck();
        this.jokers = new ArrayList<>();
        this.tarots = new ArrayList<>();
        this.discards = 0;
    }

    public void completeDeck() {
        while (!this.playerDeck.isComplete()) {
            this.playerDeck.addCard(this.englishDeck.deal());
        }
    }

    public void selectCard(int indexSelectCard){
        this.playerDeck.selectCard(indexSelectCard);
    }

    public Score play() {
        if (this.playerDeck.isEmpty()) {
            throw new EmptyPlayerDeckException();
        }
        Score score = this.playerDeck.play(this.jokers);
        this.completeDeck();
        return score;
    }

    public void discard() {
        if (this.playerDeck.isEmpty()) {
            throw new EmptyPlayerDeckException();
        }
        this.playerDeck.discard(this.jokers);
        this.completeDeck();
        this.discards++;
    }

    public void addJoker(Joker joker) {
        if (joker == null) {
            throw new InvalidJokerException();
        }
        this.jokers.add(joker);
    }

    public void addTarot(Tarot tarot) {
        if (tarot == null) {
            throw new InvalidTarotException();
        }
        this.tarots.add(tarot);
    }

    public Tarot selectTarot(int indexSelectTarot) {
        return this.tarots.get(indexSelectTarot);
    }

    public void useTarot(Tarot tarot) {
        tarot.apply();
    }
}
