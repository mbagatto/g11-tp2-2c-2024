package model;

import model.decks.EnglishDeck;
import model.decks.PlayerDeck;
import model.exceptions.EmptyPlayerDeckException;
import model.exceptions.InvalidJokerException;
import model.exceptions.InvalidTarotException;
import model.jokers.Joker;
import model.score.Score;
import model.tarots.Tarot;
import view.records.PlayerDTO;

import java.util.ArrayList;

public class Player implements ObservablePlayer {
    private String name;
    private EnglishDeck englishDeck;
    private PlayerDeck playerDeck;
    private ArrayList<Joker> jokers;
    private ArrayList<Tarot> tarots;
    private Score discards;
    private ArrayList<PlayerObserver> observers;

    public Player(String name, EnglishDeck englishDeck) {
        this.name = name;
        this.englishDeck = englishDeck;
        this.playerDeck = new PlayerDeck();
        this.jokers = new ArrayList<>();
        this.tarots = new ArrayList<>();
        this.discards = new Score(0);
        this.observers = new ArrayList<>();
    }

    public void completeDeck() {
        while (!this.playerDeck.isComplete()) {
            this.playerDeck.addCard(this.englishDeck.deal());
        }
    }

    public void selectCard(int indexSelectCard){
        this.playerDeck.selectCard(indexSelectCard);
    }

    public void noSelectCard(){
        this.playerDeck.noSelectCard();
    }

    public Score play() {
        if (this.playerDeck.isEmpty()) {
            throw new EmptyPlayerDeckException();
        }
        Score score = this.playerDeck.play(this.jokers);
        this.completeDeck();
        this.notifyObservers();
        return score;
    }

    public void discard() {
        if (this.playerDeck.isEmpty()) {
            throw new EmptyPlayerDeckException();
        }
        this.playerDeck.discard(this.jokers);
        this.completeDeck();
        this.discards.addWith(new Score(1));
        this.notifyObservers();
    }

    public void addJoker(Joker joker) {
        if (joker == null || this.jokers.size() == 5) {
            throw new InvalidJokerException();
        }
        this.jokers.add(joker);
        this.notifyObservers();
    }

    public void addTarot(Tarot tarot) {
        if (tarot == null || this.tarots.size() == 2) {
            throw new InvalidTarotException();
        }
        this.tarots.add(tarot);
        this.notifyObservers();
    }

    public void useTarot(Tarot tarot) {
        this.playerDeck.useTarot(tarot, this);
        this.notifyObservers();
    }

    public void removeJoker(Joker joker) {
        this.jokers.remove(joker);
        this.notifyObservers();
    }

    public void removeTarot(Tarot tarot) {
        this.tarots.remove(tarot);
        this.notifyObservers();
    }

    public void addObserver(PlayerObserver observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (PlayerObserver observer : this.observers) {
            observer.update(this.toDTO());
        }
    }

    public void clearSelectedCards() {
        this.playerDeck.clearSelectedCards();
    }

    public void shuffleDeck() {
        this.englishDeck.shuffleDeck();
    }

    public void reorderDeck() {
        this.playerDeck.reorderDeck(this.englishDeck);
        this.englishDeck.shuffleDeck();
    }

    public PlayerDTO toDTO() {
        return new PlayerDTO(
                this.name,
                this.jokers,
                this.tarots,
                this.englishDeck
        );
    }
}
