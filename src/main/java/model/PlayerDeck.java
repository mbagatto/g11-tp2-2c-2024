package model;

import java.util.ArrayList;

public class PlayerDeck {
    private ArrayList<Card> cards;
    private static HandCalculator handCalculator = new HandCalculator();
    private ArrayList<Card> selectedCards;

    public PlayerDeck() {
        this.cards = new ArrayList<>();
        this.selectedCards = new ArrayList<>();
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

    public Score playSelectedCard() {
        if (selectedCards.isEmpty()) {
            throw new NoSelectedCardsException();
        }
        Hand hand = handCalculator.verifyPattern(this.selectedCards);
        return hand.calculateTotalScore();
    }

    public void playTarot(int indexCard, Tarot tarot){
        cards.get(indexCard).applyTarot(tarot);
    }

    public void cleanSelectedCards() {
        this.selectedCards.clear();
    }

    public boolean isEmpty() {
        return (this.cards.isEmpty());
    }
}
