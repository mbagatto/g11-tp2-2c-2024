package model.specialCards;

import model.score.Point;
import model.score.Score;

public class ForValue implements Modifiable {
    @Override
    public void apply(Score score) {
        score.changePoint(new Point(10));
    }
}
