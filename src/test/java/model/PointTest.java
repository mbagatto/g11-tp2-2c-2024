package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    public void shouldAddAPointToAnother() {
        Point toChange = new Point(10);
        Point toAdd = new Point(5);
        Point expectedPoint = new Point(15);
        toChange.add(toAdd);
        assertEquals(toChange, expectedPoint);
    }
}
