public class ForValue implements Modifiable {


    @Override
    public void apply(Score score) {
         score.changeValue(10);
    }
}
