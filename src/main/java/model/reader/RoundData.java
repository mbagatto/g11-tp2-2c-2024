package model.reader;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoundData {
    @JsonProperty("nro")
    private int number;

    @JsonProperty("manos")
    private int hands;

    @JsonProperty("descartes")
    private int discards;

    @JsonProperty("puntajeASuperar")
    private int scoreToBeat;

    @JsonProperty("tienda")
    private StoreData store;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getHands() {
        return this.hands;
    }

    public void setHands(int hands) {
        this.hands = hands;
    }

    public int getDiscards() {
        return this.discards;
    }

    public void setDiscards(int discards) {
        this.discards = discards;
    }

    public int getScoreToBeat() {
        return this.scoreToBeat;
    }

    public void setScoreToBeat(int scoreToBeat) {
        this.scoreToBeat = scoreToBeat;
    }

    public StoreData getStore() {
        return this.store;
    }

    public void setStore(StoreData store) {
        this.store = store;
    }
}