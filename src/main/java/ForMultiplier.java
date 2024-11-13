public class ForMultiplier implements Modifiable{
    @Override
    public void apply(Score score) {
        score.setMultiplier(6);
    }
}
