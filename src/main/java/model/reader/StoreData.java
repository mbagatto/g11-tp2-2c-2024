package model.reader;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class StoreData {
    @JsonProperty("comodines")
    private List<JokerData> jokers;

    @JsonProperty("tarots")
    private List<TarotData> tarots;

    @JsonProperty("carta")
    private EnglishCardData card;

    public List<JokerData> getJokers() {
        return this.jokers;
    }

    public void setJokers(List<JokerData> jokers) {
        this.jokers = jokers;
    }

    public List<TarotData> getTarots() {
        return this.tarots;
    }

    public void setTarots(List<TarotData> tarots) {
        this.tarots = tarots;
    }

    public EnglishCardData getEnglishCardData() {
        return card;
    }

    public void setEnglishCardData(EnglishCardData card) {
        this.card = card;
    }

}