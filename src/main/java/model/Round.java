package model;

public class Round {
    private int number;
    private int hands;
    private int discards;
    private int scoreToBeat;
    private Store store;

    public Round(int number, int hands, int discards, int scoreToBeat, Store store) {
        this.number = number;
        this.hands = hands;
        this.discards = discards;
        this.scoreToBeat = scoreToBeat;
        this.store = store;
    }

}
