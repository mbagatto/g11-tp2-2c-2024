package view;

import controller.buttonHandlers.HandlerAddJoker;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Purchasable;
import view.buttons.ButtonAdd;

public class ShopProductView extends VBox {
    public ShopProductView(Purchasable purchasable) {
        super();
        this.setId("purchasable-view");
        this.setAlignment(Pos.CENTER);
        Label name = new Label(purchasable.getName());
        name.setId("purchasable-name");

        Image image = new Image("file:src/resources/textures/" + purchasable.toString() + ".png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(110);
        imageView.setFitWidth(85);

        Label description = new Label(purchasable.getDescription());
        description.setId("purchasable-description");
        description.setVisible(false);

        Button addButton = new ButtonAdd(imageView, name, description);

        this.getChildren().add(name);
        this.getChildren().add(addButton);
        this.getChildren().add(description);
    }
}
