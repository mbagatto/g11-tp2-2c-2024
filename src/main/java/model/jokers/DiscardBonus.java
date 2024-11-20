//package model.jokers;
//
//import model.hands.Hand;
//import model.score.Score;
//
//public class DiscardBonus extends Effect {
//    private int discards;
//
//    public DiscardBonus(Score score) {
//        super(score);
//    }
//
//    public void setDiscards(int discard) {
//        this.discards = discard;
//    }
//
//    public void apply(Hand hand) {
//        this.score.multiplyPoint(new Score(discards));
//        hand.addToScore(this.score);
//    }
//}
