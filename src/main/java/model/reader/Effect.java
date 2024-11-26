package model.reader;

import com.fasterxml.jackson.annotation.JsonProperty;

class Effect {
    @JsonProperty("puntos")
    private int points;

    @JsonProperty("multiplicador")
    private int multiplier;

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
