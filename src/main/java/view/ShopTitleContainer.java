package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ShopTitleContainer extends VBox {
    public ShopTitleContainer() {
        super();
        this.setId("shop-title-container");
        this.setLayoutX(62);
        this.setLayoutY(100);
        this.setMinWidth(375);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(2);

        Label title = new Label("TIENDA");
        title.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 100px;"
        );

        Label subtitle = new Label("¡Preparate para la siguiente ronda!");
        subtitle.setStyle(
                "-fx-text-fill: white;"
                + "-fx-font-size: 24px;"
        );

        this.getChildren().add(title);
        this.getChildren().add(subtitle);
    }
}
