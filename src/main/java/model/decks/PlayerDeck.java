package model.decks;

import model.ObservablePlayerDeck;
import model.ObserverPlayerDeck;
import model.Player;
import model.PlayerDeckObserver;
import model.exceptions.NoSelectedCardsException;
import model.hands.Hand;
import model.cards.Card;
import model.identifiers.*;
import model.jokers.DiscardBonus;
import model.jokers.Joker;
import model.score.Score;
import model.tarots.Tarot;
import view.records.EnglishCardDTO;
import view.records.PlayerDeckDTO;
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
        initializeIdentifiersChain();
        this.actualHand = this.handIdentifier.identify(this.selectedCards);
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

    public void selectCard(int indexCard){
        this.selectedCards.add(this.cards.get(indexCard));
        this.actualHand = handIdentifier.identify(this.selectedCards);
    }

    public void noSelectCard(){
        this.actualHand = handIdentifier.identify(this.selectedCards);
    }

    public Score play(ArrayList<Joker> jokers) {
        if (selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }

        Hand hand = handIdentifier.identify(this.selectedCards);

        Score score = hand.calculateScore(this.selectedCards, jokers);
        this.playedCards.addAll(this.selectedCards);
        this.reset(selectedCards);
        return score;
    }

    public void discard(ArrayList<Joker> jokers) {
        if (selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }
        DiscardBonus discardBonusJoker = null;
        for (Joker joker : jokers) {
            if (joker.equals(new DiscardBonus(joker))) {
                discardBonusJoker = (DiscardBonus) joker;
                discardBonusJoker.incrementDiscards();
            }
        }
        this.playedCards.addAll(this.selectedCards);
        this.reset(selectedCards);
    }

    public void reset(ArrayList<Card> selectedCards) {
        ArrayList<Card> discardCards = new ArrayList<>(selectedCards);
        this.cards.removeAll(selectedCards);
        this.selectedCards.clear();
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
                                                                                        new NullCardIdentifier()
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
        ArrayList<EnglishCardDTO> cardRecords = new ArrayList<>();
        for(Card card : this.cards){
            cardRecords.add(card.toRecord());
        }

        return new PlayerDeckDTO(cardRecords, this.actualHand.toRecord());
    }

    public void clearSelectedCards() {
        this.selectedCards.clear();
    }

    public void useTarot(Tarot tarot, Player player) {
        if (this.selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }
        if (this.selectedCards.size() == 1) {
            tarot.setTarget(this.selectedCards.getFirst());
        }
        tarot.apply(player);
    }

    public void reorderDeck(EnglishDeck deck){
        this.playedCards.addAll(this.cards);
        this.cards.clear();
        deck.reorderDeck(this.playedCards);
        this.playedCards.clear();
    }

}
