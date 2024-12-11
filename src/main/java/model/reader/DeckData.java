package model.reader;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class DeckData {
    @JsonProperty("mazo")
    private ArrayList<EnglishCardData> deck;

    public ArrayList<EnglishCardData> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<EnglishCardData> deck) {
        this.deck = deck;
    }
}
