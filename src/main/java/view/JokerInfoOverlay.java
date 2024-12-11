package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import view.dtos.JokerDTO;

public class JokerInfoOverlay extends VBox {
    public JokerInfoOverlay(JokerDTO jokerDTO) {
        super();
        this.setId("joker-popup");
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        this.setMinWidth(215);
        this.setMaxWidth(215);
        this.setMinHeight(125);
        this.setMaxHeight(125);
        this.setVisible(false);

        Label name = new Label(jokerDTO.name());
        name.setId("joker-popup-name");

        Label description = new Label(jokerDTO.description());
        description.setId("joker-popup-description");
        description.setWrapText(true);
        description.setTextAlignment(TextAlignment.CENTER);
        description.setAlignment(Pos.CENTER);
        description.setMinWidth(200);
        description.setMaxWidth(200);
        description.setMinHeight(60);
        description.setMaxHeight(60);

        Label type = new Label("Comodin");
        type.setId("joker-popup-type");
        type.setPrefWidth(80);
        type.setAlignment(Pos.CENTER);

        this.getChildren().addAll(name, description, type);
    }
}
