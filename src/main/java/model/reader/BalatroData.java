package model.reader;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BalatroData {

    @JsonProperty("rondas")
    private List<RoundData> rounds;

    @JsonProperty("mazo")
    private List<EnglishCardData> deck;

    public List<EnglishCardData> getDeck() {
        return deck;
    }

    public void setDeck(List<EnglishCardData> deck) {
        this.deck = deck;
    }

    public List<RoundData> getRounds() {
        return rounds;
    }

    public void setRounds(List<RoundData> rounds) {
        this.rounds = rounds;
    }

}