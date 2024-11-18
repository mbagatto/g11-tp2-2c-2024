package model;

public class ForMultiplier implements Modifiable{
//    @Override
//    public void apply(Score score) {
//        score.setMultiplier(6);
//    }

    @Override
    public void apply(Score score) {
        score.changeMultiplier(new Multiplier(6));
    }

}
