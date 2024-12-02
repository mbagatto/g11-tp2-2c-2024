package view;

import javafx.scene.control.Button;

public class ButtonAdd extends Button {
    public ButtonAdd() {
        super("Add");
        this.setMinWidth(150);
        this.setStyle(
                "-fx-font-size: 30px;"
                + "-fx-background-color: rgba(251,56,56,0.5);"
                + "-fx-text-fill: rgba(255,255,255,0.97);"
                + "-fx-background-radius: 10px;"
                + "-fx-cursor: hand;"
        );
    }
}
