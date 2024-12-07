package model.game;

import model.ClassDTO;
import model.Player;

public record GameDTO(
    Player player,
    Round round
) implements ClassDTO {}
