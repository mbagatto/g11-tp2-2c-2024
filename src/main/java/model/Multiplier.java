package model;

import java.util.Objects;

public class Multiplier {

    private int value;

    public Multiplier(int value) {
        this.value = value;
    }

    public Multiplier() {
        this.value = 0;
    }

    public void add(Multiplier otherMultiplier) {
        this.value = this.value + otherMultiplier.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multiplier multiplier = (Multiplier) o;
        return this.value == multiplier.value;
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }

    public boolean isZero() {
        return this.value == 0;
    }

    public int applyMultiplierTo(Point toMultiplier) {
        return toMultiplier.multiplyBy(this.value);
    }

    public void changeMultiplier(Multiplier otherMultiplier) {
        this.value = otherMultiplier.value;
    }
}
