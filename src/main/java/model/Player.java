package model;

import model.decks.EnglishDeck;
import model.decks.PlayerDeck;
import model.exceptions.EmptyPlayerDeckException;
import model.exceptions.InvalidJokerException;
import model.jokers.Joker;
import model.score.Score;
import java.util.ArrayList;

public class Player {
    private String name;
    private EnglishDeck englishDeck;
    private PlayerDeck playerDeck;
    private ArrayList<Joker> jokers;
    private int discards;
//    private ArrayList<Tarot> tarots;


    public Player(String name, EnglishDeck englishDeck) {
        this.name = name;
        this.englishDeck = englishDeck;
        this.playerDeck = new PlayerDeck();
        this.jokers = new ArrayList<>();
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
//
//    public void useTarotOnCard(int tarotIndex, int cardIndex) {
//        if (tarotIndex < 0 || tarotIndex >= tarots.size()) {
//            throw new IndexOutOfBoundsException("Índice de Tarot inválido.");
//        }
//
//        Tarot tarot = tarots.get(tarotIndex);
//        playerDeck.applyEffectToCard(tarot, cardIndex);
//    }
//
//
//    public void useTarotOnHand(int tarotIndex) {
//        if (tarotIndex < 0 || tarotIndex >= tarots.size()) {
//            throw new IndexOutOfBoundsException("Índice de Tarot inválido.");
//        }
//
//        Tarot tarot = tarots.get(tarotIndex);
//        playerDeck.applyEffectToHand(tarot);
//    }
}