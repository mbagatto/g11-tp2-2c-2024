package view.dtos;

import model.game.Round;
import model.Player;

public record GameDTO
        (
                Player player,
                Round round
        ) implements ClassDTO {}
