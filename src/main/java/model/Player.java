package model;

public class Player {
    private String name;
    private EnglishDeck englishDeck;
    private PlayerDeck playerDeck;

    public Player(String name, EnglishDeck englishDeck) {
        this.name = name;
        this.englishDeck = englishDeck;
        this.playerDeck = new PlayerDeck();
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
        return playerDeck.playSelectedCard();
    }
}
