package view;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Player;
import model.ShopObserver;
import model.game.Game;
import view.dtos.GameDTO;
import model.game.Shop;
import view.buttons.ButtonNextRound;
import view.dtos.ShopDTO;

public class ProductsContainer extends VBox implements ShopObserver {
    private Group groupView;
    private Player player;
    private Shop shop;

    public ProductsContainer(Stage stage, Group groupView, Player player, Shop shop, MainMenuView mainMenuView, Game game) {
        super();
        this.groupView = groupView;
        this.player = player;
        this.shop = shop;
        shop.addObserver(this);
        ShopDTO shopDTO = shop.toDTO();

        this.setId("products-container");
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(125);
        this.setLayoutX(550);
        this.setLayoutY(405);
        this.setPrefWidth(900);
        this.setPrefHeight(800);

        this.getChildren().add(new ButtonNextRound(stage, mainMenuView, game));
        this.getChildren().add(new ProductsContainerView(player, shopDTO.jokers(), shopDTO.tarots(), shop));
    }

    @Override
    public void update(ShopDTO shopDTO) {
        this.getChildren().removeLast();

        this.getChildren().add(new ProductsContainerView(this.player, shopDTO.jokers(), shopDTO.tarots(), this.shop));

        this.groupView.getChildren().remove(this);
        this.groupView.getChildren().add(this);
    }
}
