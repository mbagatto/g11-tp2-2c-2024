package model;

import model.decks.EnglishDeck;
import model.decks.PlayerDeck;
import model.exceptions.EmptyPlayerDeckException;
import model.exceptions.InvalidJokerException;
import model.exceptions.InvalidTarotException;
import model.jokers.Joker;
import model.score.Score;
import model.tarots.Tarot;
import view.records.PlayerRecord;

import java.util.ArrayList;

public class Player implements Observable, Purchaser, ObservablePlayer {
    private String name;
    private EnglishDeck englishDeck;
    private PlayerDeck playerDeck;
    private ArrayList<Joker> jokers;
    private ArrayList<Tarot> tarots;
    private Score discards;
    private ArrayList<Observer> observers;

    //private ArrayList<ObservablePlayer> observersPlayers;
    private ArrayList<ObserverPlayer> observersPlayer;

    public Player(String name, EnglishDeck englishDeck) {
        this.name = name;
        this.englishDeck = englishDeck;
        this.playerDeck = new PlayerDeck();
        this.jokers = new ArrayList<>();
        this.tarots = new ArrayList<>();
        this.discards = new Score(0);
        this.observers = new ArrayList<>();

        this.observersPlayer = new ArrayList<>();
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
        this.discards.addWith(new Score(1));
    }

    public void addJoker(Joker joker) {
        if (joker == null || this.jokers.size() == 5) {
            throw new InvalidJokerException();
        }
        this.jokers.add(joker);
    }

    public void addTarot(Tarot tarot) {
        if (tarot == null || this.tarots.size() == 2) {
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

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void addObserverPlayer(ObserverPlayer observerPlayer) {
        this.observersPlayer.add(observerPlayer);
        observerPlayer.updatePlayer(this.toRecord());
    }

    @Override
    public void notifyObserversPlayer() {
        for (ObserverPlayer observerPlayer : this.observersPlayer) {
            observerPlayer.updatePlayer(this.toRecord());
        }
    }



    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update();
        }
    }

    public PlayerRecord toRecord() {
        return new PlayerRecord(
                this.name,
                this.playerDeck.toRecord(), // Copia inmutable del mazo
                new ArrayList<>(this.jokers),               // Copia inmutable de los comodines
                new ArrayList<>(this.tarots),               // Copia inmutable de las cartas de tarot
                this.discards.toRecord()                    // Puntuación de descartes
        );
    }

    @Override
    public ArrayList<Joker> getJokers() {
        return this.jokers;
    }

    @Override
    public ArrayList<Tarot> getTarots() {
        return this.tarots;
    }

    public void removeJoker(Joker joker) {
        this.jokers.remove(joker);
    }

    public void removeTarot(Tarot tarot) {
        this.tarots.remove(tarot);
    }

    public void addObserverForHand(ObserverHand observerHand) {
        this.playerDeck.addObserverForHand(observerHand);
    }
}
