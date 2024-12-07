package view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Player;
import model.PlayerObserver;
import model.game.Shop;
import view.records.PlayerDTO;

public class PlayerTarotsContainer extends VBox implements PlayerObserver {
    private PreparationView stage;
    private Player player;
    private Shop shop;

    public PlayerTarotsContainer(PreparationView stage, Player player, Shop shop) {
        super();
        this.stage = stage;
        this.player = player;
        this.shop = shop;
        player.addObserver(this);
        PlayerDTO playerDTO = player.toDTO();

        this.setLayoutX(1300);
        this.setLayoutY(60);
        this.setSpacing(5);

        this.getChildren().add(new TarotsContainerView(player, playerDTO.tarots(), shop));

        Label tarotsCount = new Label(playerDTO.jokers().size() + "/2");
        tarotsCount.setId("player-tarots-count");
        this.getChildren().add(tarotsCount);
    }

    @Override
    public void update(PlayerDTO playerDTO) {
        this.getChildren().removeFirst();
        this.getChildren().removeFirst();

        this.getChildren().add(new TarotsContainerView(player, playerDTO.tarots(), shop));

        Label tarotsCount = new Label(playerDTO.tarots().size() + "/2");
        tarotsCount.setId("player-tarots-count");
        this.getChildren().add(tarotsCount);

        this.stage.updateView(this);
    }
}
