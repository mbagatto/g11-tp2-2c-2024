package model.decks;

import model.ObservablePlayerDeck;
import model.Player;
import model.PlayerDeckObserver;
import model.exceptions.NoSelectedCardsException;
import model.hands.Hand;
import model.cards.Card;
import model.hands.NullHand;
import model.identifiers.*;
import model.jokers.DiscardBonus;
import model.jokers.Joker;
import model.score.Score;
import model.tarots.Tarot;
import view.dtos.PlayerDeckDTO;
import java.util.ArrayList;

public class PlayerDeck implements ObservablePlayerDeck {
    private ArrayList<Card> cards;
    private ArrayList<Card> selectedCards;
    private ArrayList<Card> playedCards;
    private HandIdentifier handIdentifier;
    private ArrayList<PlayerDeckObserver> observers;
    private Hand actualHand;

    public PlayerDeck() {
        this.cards = new ArrayList<>();
        this.selectedCards = new ArrayList<>();
        this.playedCards = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.actualHand = NullHand.getInstance();
        initializeIdentifiersChain();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean isComplete() {
        return (this.cards.size() == 8);
    }

    public boolean isEmpty() {
        return (this.cards.isEmpty());
    }

    public void selectCard(Card card){
        this.selectedCards.add(card);
        this.actualHand = handIdentifier.identify(this.selectedCards);
        this.notifyObservers();
    }

    public void unselectCard(Card card) {
        this.selectedCards.remove(card);
        this.actualHand = handIdentifier.identify(this.selectedCards);
        this.notifyObservers();
    }

    public Score play(ArrayList<Joker> jokers) {
        if (selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }

        Hand hand = handIdentifier.identify(this.selectedCards);

        Score score = hand.calculateScore(this.selectedCards, jokers);
        this.reset(selectedCards);
        return score;
    }

    public void discard(ArrayList<Joker> jokers, Score discards) {
        if (selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }

        ArrayList<Joker> resetJokers = new ArrayList<>();
        for (Joker joker : jokers) {
            if (joker.hasType("Discard Bonus")) {
                DiscardBonus discardBonus = new DiscardBonus(joker);
                discardBonus.setDiscards(discards);
                resetJokers.add(discardBonus);
            } else {
                resetJokers.add(joker);
            }
        }
        jokers.clear();
        jokers.addAll(resetJokers);
        this.reset(selectedCards);
    }

    public void reset(ArrayList<Card> selectedCards) {
        this.playedCards.addAll(selectedCards);
        this.cards.removeAll(selectedCards);
        this.selectedCards.clear();
    }

    public void useTarot(Tarot tarot, Player player) {
        tarot.apply(player, this.selectedCards);
    }

    public boolean maxSelectedReached() {
        return (this.selectedCards.size() >= 5);
    }

    public void reorderDeck(EnglishDeck deck) {
        deck.fillDeck(this.playedCards);
        deck.fillDeck(this.cards);
        this.cards.clear();
        this.playedCards.clear();
    }

    private void initializeIdentifiersChain() {
        this.handIdentifier = new RoyalFlushIdentifier(
                new StraightFlushIdentifier(
                        new FourOfAKindIdentifier(
                                new FullHouseIdentifier(
                                        new FlushIdentifier(
                                                new StraightIdentifier(
                                                        new ThreeOfAKindIdentifier(
                                                                new TwoPairIdentifier(
                                                                        new PairIdentifier(
                                                                                new HighCardIdentifier(
                                                                                        new NullHandIdentifier()
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ));
    }

    public void addObserver(PlayerDeckObserver observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (PlayerDeckObserver observer : observers) {
            observer.update(this.toDTO());
        }
    }

    public PlayerDeckDTO toDTO(){
        return new PlayerDeckDTO(this.cards, this.actualHand.toDTO());
    }
}
