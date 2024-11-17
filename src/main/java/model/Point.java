package model;

import java.util.Objects;

public class Point {

    private int value;

    @Override
    public boolean equals(Object o) {
        if(o instanceof Point) {
            Point point = (Point) o;
            return this.value == point.value;
        }else{
            throw new IsNotAnInstanceOfPointException();
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }

    public Point(int value) {
        this.value = value;
    }

    public void add(Point toAdd) {
        this.value += toAdd.value;
    }

    public void changePoint(Point otherPoint) {
        this.value = otherPoint.value;
    }

    public int multiplyBy(int multiplier) {
        return this.value * multiplier;
    }

}
