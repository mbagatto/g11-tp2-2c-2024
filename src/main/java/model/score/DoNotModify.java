package model.score;

public class DoNotModify extends ScoreModifier {

    public DoNotModify() {
        super();
    }

    public Score modify(Score score) {
        return score.multiplyWith(this.score);
    }
}
