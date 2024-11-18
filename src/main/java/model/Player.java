package model;

public class Player {
    private String name;
    private Deck deck;
    private PlayerDeck playerDeck;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
        this.playerDeck = new PlayerDeck();
    }

    public void completeDeck() {
        while (!this.playerDeck.isComplete()) {
            this.playerDeck.addCard(this.deck.deal());
        }
    }

    public boolean hasEnoughCards() {
        return (this.playerDeck.isComplete());
    }

    public void selectCard(int indexSelectCard){
        this.playerDeck.selectCard(indexSelectCard);
    }

    public Score play() {
        if (this.playerDeck.isEmpty()) {
            throw new EmptyPlayerDeckException();
        }
        return playerDeck.playSelectedCards();
    }
}
