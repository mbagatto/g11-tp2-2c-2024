package model.decks;

import model.Observable;
import model.Observer;
import model.exceptions.NoSelectedCardsException;
import model.hands.Hand;
import model.cards.Card;
import model.identifiers.*;
import model.jokers.DiscardBonus;
import model.jokers.Joker;
import model.score.Score;
import view.records.EnglishCardRecord;
import view.records.PlayerDeckRecord;

import java.util.ArrayList;

public class PlayerDeck implements Observable {
    private ArrayList<Card> cards;
    private ArrayList<Card> selectedCards;
    private HandIdentifier handIdentifier;
    private ArrayList<Observer> observers;


    public PlayerDeck() {
        this.cards = new ArrayList<>();
        this.selectedCards = new ArrayList<>();
        this.observers = new ArrayList<>();
        initializeIdentifiersChain();

    }

    public void addCard(Card card) {
        System.out.println("Desde addCard: "+this.cards.toString());
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
        System.out.println(this.selectedCards.toString());
    }

    public Score play(ArrayList<Joker> jokers) {
        if (selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }
        System.out.println("CARTAS JUGADAS: "+this.selectedCards.toString());
        Hand hand = handIdentifier.identify(this.selectedCards);
        Score score = hand.calculateScore(this.selectedCards, jokers);
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
                                                                                new HighCardIdentifier()
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ));
    }

    public PlayerDeckRecord toRecord(){
        ArrayList<EnglishCardRecord> cardRecords = new ArrayList<>();
        for(Card card : this.cards){
            cardRecords.add(card.toRecord());
        }

        return new PlayerDeckRecord(cardRecords);
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {

        }
    }
}
