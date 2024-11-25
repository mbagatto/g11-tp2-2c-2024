package model.score;

public abstract class ScoreModifier {
    protected Score score;

    public ScoreModifier() {
        this.score = new Score(1);
    }

    public ScoreModifier(Score score) {
        this.score = score;
    }

    public abstract Score modify(Score score);
}
