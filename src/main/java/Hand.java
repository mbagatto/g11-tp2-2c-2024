import java.util.ArrayList;

public abstract class Hand {
    private int value;
    private int multiplicator;

    public abstract boolean checkEquality(ArrayList<Card> cards);
}
