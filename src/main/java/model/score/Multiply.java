package model.score;

public class Multiply extends ScoreModifier {

    public Multiply(Score score) {
        super(score);
    }

    public Score modify(Score score) {
        return score.multiplyWith(this.score);
    }
}
