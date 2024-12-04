package model.decks;

import model.ObservablePlayerDeck;
import model.ObserverPlayerDeck;
import model.exceptions.NoSelectedCardsException;
import model.hands.Hand;
import model.cards.Card;
import model.hands.NullHand;
import model.identifiers.*;
import model.jokers.DiscardBonus;
import model.jokers.Joker;
import model.score.Score;
import view.records.EnglishCardRecord;
import view.records.PlayerDeckRecord;
import java.util.ArrayList;

public class PlayerDeck implements ObservablePlayerDeck {
    private ArrayList<Card> cards;
    private ArrayList<Card> selectedCards;
    private HandIdentifier handIdentifier;
    private ArrayList<ObserverPlayerDeck> observers;
    private Hand actualHand;


    public PlayerDeck() {
        this.cards = new ArrayList<>();
        this.selectedCards = new ArrayList<>();
        this.observers = new ArrayList<>();
        initializeIdentifiersChain();
//        this.actualHand = new NullHand(); // Cambio medio grave
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
        System.out.println("selectCard(): " +this.actualHand.toRecord().name());
        System.out.println("Lista de cartas: " +this.selectedCards.toString());
    }

    public void noSelectCard(){
        this.actualHand = handIdentifier.identify(this.selectedCards);
    }

    public Score play(ArrayList<Joker> jokers) {
        if (selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }
        //System.out.println("CARTAS JUGADAS: "+this.selectedCards.toString());

        //Score score = this.actualHand.calculateScore(this.selectedCards, jokers);
        //this.actualHand = handIdentifier.identify(this.selectedCards);

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

    public PlayerDeckRecord toRecord(){
        ArrayList<EnglishCardRecord> cardRecords = new ArrayList<>();
        for(Card card : this.cards){
            cardRecords.add(card.toRecord());
        }

        return new PlayerDeckRecord(cardRecords, this.actualHand.toRecord());
    }

    public void addObserverForPlayerDeck(ObserverPlayerDeck observerPlayerDeck) {
        this.observers.add(observerPlayerDeck);
    }

    @Override
    public void addObserversPlayerDeck(ObserverPlayerDeck observerPlayerDeck) {
        this.observers.add(observerPlayerDeck);
        observerPlayerDeck.updatePlayerDeck(this.toRecord());
    }

    @Override
    public void notifyObserversPlayerDeck() {
        for (ObserverPlayerDeck observerPlayerDeck : this.observers) {
            System.out.println("PLEYERDECK: " +this.toRecord().handRecord().name());
            observerPlayerDeck.updatePlayerDeck(this.toRecord());
        }
    }

    public void clearSelectedCards() {
        this.selectedCards.clear();
    }

}
