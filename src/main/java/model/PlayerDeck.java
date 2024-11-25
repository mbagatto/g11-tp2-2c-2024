package model;

import model.exceptions.NoSelectedCardsException;
import model.hands.Hand;
import model.cards.Card;
import model.identifiers.*;
import model.jokers.Joker;
import model.score.Score;

import java.util.ArrayList;

public class PlayerDeck {
    private ArrayList<Card> cards;
    private ArrayList<Card> selectedCards;
    private HandIdentifier handIdentifier;

    public PlayerDeck() {
        this.cards = new ArrayList<>();
        this.selectedCards = new ArrayList<>();
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

    public void selectCard(int indexCard){
        selectedCards.add(this.cards.get(indexCard));
    }

    public Score play(ArrayList<Joker> jokers) {
        if (selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }
        Hand hand = handIdentifier.identify(this.selectedCards);
        return hand.calculateScore(jokers);
    }

    public void reset() {
        this.cards.clear();
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


}
