package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Player;

public class ButtonAdd extends Button {
    public ButtonAdd(ImageView imageView, Label name, Label description) {
        super();
        this.setId("button-add");
        this.setGraphic(imageView);
        this.setStyle("-fx-background-color: transparent;");
        this.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            description.setVisible(true);
            name.setStyle("-fx-text-fill: rgb(255, 235, 167);");
        });
        this.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            description.setVisible(false);
            name.setStyle("-fx-text-fill: white;");
        });
    }
}
