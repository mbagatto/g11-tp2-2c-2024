package model.reader;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardData {
    @JsonProperty("nombre")
    private String name;

    @JsonProperty("palo")
    private String suit;

    @JsonProperty("numero")
    private String number;

    @JsonProperty("puntos")
    private int points;

    @JsonProperty("multiplicador")
    private double multiplicator;

    public String getName() {
        return this.name;
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
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getMultiplicator() {
        return this.multiplicator;
    }

    public void setMultiplicator(double multiplicator) {
        this.multiplicator = multiplicator;
    }
}
