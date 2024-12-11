package view;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.Drawable;
import java.util.Random;

public class EnglishCardView extends VBox implements Drawable {

    private ImageView imageView;

    public EnglishCardView(ImageView cardView){
        super();
        this.imageView = cardView;
        this.draw();
    }

    @Override
    public void draw() {
        this.setStyle(
                "-fx-background-color: white; " +
                        "-fx-border-color: gray; " +
                        "-fx-border-radius: 7; " +
                        "-fx-background-radius: 7;" +
                        "-fx-cursor: hand;"
        );
        this.imageView.setFitHeight(200);
        this.imageView.setFitWidth(150);
        this.setPrefSize(150, 200);
        this.addSwingEffect();
        this.getChildren().add(this.imageView);
    }

    public void addSwingEffect() {
        Random random = new Random();
        double randomStartAngle = -7 + (7 - (-7)) * random.nextDouble();
        double randomEndAngle = randomStartAngle > 0 ? randomStartAngle - 7 : randomStartAngle + 7;

        RotateTransition swing = new RotateTransition(Duration.millis(1200), this);
        swing.setFromAngle(randomStartAngle);
        swing.setToAngle(randomEndAngle);
        swing.setCycleCount(RotateTransition.INDEFINITE);
        swing.setAutoReverse(true);
        swing.setInterpolator(Interpolator.EASE_BOTH);

        swing.play();
    }

}
