package model.score;

public class Change extends ScoreModifier {
    public Change(Score score) {
        super(score);
    }

    public Score modify(Score score) {
        return this.score;
    }
}
