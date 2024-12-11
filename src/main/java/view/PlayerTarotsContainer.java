package view;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Player;
import model.PlayerObserver;
import model.game.Shop;
import view.dtos.PlayerDTO;

public class PlayerTarotsContainer extends VBox implements PlayerObserver {
    private Group stage;
    private Player player;
    private Shop shop;
    private TarotsContainerView tarotsContainerView;

    public PlayerTarotsContainer(Group stage, Player player, Shop shop) {
        super();
        this.stage = stage;
        this.player = player;
        this.shop = shop;
        player.addObserver(this);
        PlayerDTO playerDTO = player.toDTO();

        this.setLayoutX(1300);
        this.setLayoutY(100);
        this.setSpacing(5);

        this.tarotsContainerView = new TarotsContainerView(player, playerDTO.tarots(), shop);
        this.getChildren().add(tarotsContainerView);

        Label tarotsCount = new Label(playerDTO.tarots().size() + "/2");
        tarotsCount.setId("player-tarots-count");
        this.getChildren().add(tarotsCount);
    }

    @Override
    public void update(PlayerDTO playerDTO) {
        this.getChildren().clear();

        this.getChildren().add(new TarotsContainerView(player, playerDTO.tarots(), shop));

        Label tarotsCount = new Label(playerDTO.tarots().size() + "/2");
        tarotsCount.setId("player-tarots-count");
        this.getChildren().add(tarotsCount);

        this.stage.getChildren().remove(this);
        this.stage.getChildren().add(this);
    }

    public void setUseButtons() {
        this.tarotsContainerView.setUseButtons();
    }
}
