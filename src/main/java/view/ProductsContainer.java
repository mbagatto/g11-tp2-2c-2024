package view;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Player;
import model.ShopObserver;
import model.game.Shop;
import view.buttons.ButtonNextRound;
import view.records.ShopDTO;

public class ProductsContainer extends VBox implements ShopObserver {
    private PreparationView pView;
    private Player player;
    private Shop shop;

    public ProductsContainer(Stage stage, PreparationView pView, Player player, Shop shop) {
        super();
        this.pView = pView;
        this.player = player;
        this.shop = shop;
        shop.addObserver(this);
        ShopDTO shopDTO = shop.toDTO();

        this.setId("products-container");
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(125);
        this.setLayoutX(550);
        this.setLayoutY(305);
        this.setPrefWidth(900);
        this.setPrefHeight(800);

        this.getChildren().add(new ButtonNextRound(stage));
        this.getChildren().add(new ProductsContainerView(player, shopDTO.jokers(), shopDTO.tarots(), shop));
    }

    @Override
    public void update(ShopDTO shopDTO) {
        this.getChildren().removeLast();

        this.getChildren().add(new ProductsContainerView(this.player, shopDTO.jokers(), shopDTO.tarots(), this.shop));

        this.pView.updateView(this);
    }
}
