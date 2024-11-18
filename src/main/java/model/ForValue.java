package model;

public class ForValue implements Modifiable {
    @Override
    public void apply(Score score) {
//         score.setValue(10);
        score.changePoint(new Point(10));
    }
}
