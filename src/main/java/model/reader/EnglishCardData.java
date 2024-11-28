package model.reader;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnglishCardData {

    @JsonProperty("nombre")
    private String name;
    @JsonProperty("palo")
    private String suit;
    @JsonProperty("numero")
    private String number;
    @JsonProperty("puntos")
    private int points;
    @JsonProperty("multiplicador")
    private int multiplier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

}
