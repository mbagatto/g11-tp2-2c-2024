package model;

import model.hands.Hand;
import model.jokers.Joker;
import model.specialCards.Tarot;
import model.cards.Card;
import model.identifiers.*;
import model.score.Score;

import java.util.ArrayList;

public class PlayerDeck {
    private ArrayList<Card> cards;
    private ArrayList<Card> selectedCards;
    private HandIdentifier handIdentifier;

    public PlayerDeck() {
        this.cards = new ArrayList<>();
        this.selectedCards = new ArrayList<>();
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
                )
        );
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean isComplete() {
        return (this.cards.size() == 8);
    }

    public void selectCard(int indexCard){
        selectedCards.add(this.cards.get(indexCard));
    }

    public Score playSelectedCards(ArrayList<Joker> jokers) {
        if (selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }
        Hand hand = handIdentifier.identify(this.selectedCards);
        Score score = hand.calculateScore(jokers);
//        this.discardSelectedCards();
        return score;
    }

    public void playTarot(int indexCard, Tarot tarot){
        cards.get(indexCard).applyTarot(tarot);
    }

    public void cleanSelectedCards() {
        this.selectedCards.clear();
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }


//    public void discardSelectedCards() {
//        this.cards.removeAll(this.selectedCards);
//        this.selectedCards.clear();
//    }
}
