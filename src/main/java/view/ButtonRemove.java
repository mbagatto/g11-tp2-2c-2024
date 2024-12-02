package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ButtonRemove extends Button {
    public ButtonRemove(ImageView graphic, Label description) {
        super();
        this.setGraphic(graphic);
        this.setStyle(
                "-fx-background-color: transparent;"
                + "-fx-cursor: hand;"
        );
        this.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> { description.setVisible(true);});
        this.addEventHandler(MouseEvent.MOUSE_EXITED, event -> { description.setVisible(false);});
    }
}
