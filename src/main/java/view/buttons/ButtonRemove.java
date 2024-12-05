package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ButtonRemove extends Button {
    public ButtonRemove(ImageView imageView, String description) {
        super();
        this.setId("button-remove");
        this.setGraphic(imageView);
        this.setStyle("-fx-background-color: transparent;");
    }
}
