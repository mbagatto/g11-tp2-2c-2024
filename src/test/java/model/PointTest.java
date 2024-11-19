package model;

import model.score.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    public void test01APointShouldAddAPointToOtherPointCorrectly() {
        // Arrange
        Point toChange = new Point(10);
        Point toAdd = new Point(5);
        Point expectedPoint = new Point(15);
        // Act
        toChange.add(toAdd);
        // Assert
        assertEquals(expectedPoint, toChange);
    }
}
