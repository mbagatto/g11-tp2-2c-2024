package model.decks;

import model.exceptions.NoSelectedCardsException;
import model.hands.Hand;
import model.cards.Card;
import model.identifiers.*;
import model.jokers.DiscardBonus;
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
        Score score = hand.calculateScore(jokers);
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
}
