package view;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;

public class ScaledSceneFactory {
    private static final double DESIGN_WIDTH = 1920;
    private static final double DESIGN_HEIGHT = 1080;

    private ScaledSceneFactory() {
    }

    public static Scene create(Parent root) {
        Group container = new Group(root);
        var screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(container, screenBounds.getWidth(), screenBounds.getHeight(), Color.BLACK);

        Scale scale = new Scale(1, 1, 0, 0);
        root.getTransforms().add(scale);

        Runnable rescale = () -> {
            double factor = Math.min(scene.getWidth() / DESIGN_WIDTH, scene.getHeight() / DESIGN_HEIGHT);
            scale.setX(factor);
            scale.setY(factor);
            root.setLayoutX((scene.getWidth() - DESIGN_WIDTH * factor) / 2);
            root.setLayoutY((scene.getHeight() - DESIGN_HEIGHT * factor) / 2);
        };

        scene.widthProperty().addListener((obs, oldVal, newVal) -> rescale.run());
        scene.heightProperty().addListener((obs, oldVal, newVal) -> rescale.run());
        rescale.run();

        return scene;
    }
}
