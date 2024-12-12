package model.score;

public class Add extends ScoreModifier {
    public Add(Score score) {
        super(score);
    }

    public Score modify(Score score) {
        return score.addWith(this.score);
    }
}
