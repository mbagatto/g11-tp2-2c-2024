package view.records;

import model.ClassDTO;
import model.game.Shop;

public record RoundDTO
        (
        String number,
        String actualScore,
        String scoreToBeat,
        String hands,
        String discards,
        Shop shop
        ) implements ClassDTO {}
