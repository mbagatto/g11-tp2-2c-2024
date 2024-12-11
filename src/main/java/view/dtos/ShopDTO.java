package view.dtos;

import model.jokers.Joker;
import model.tarots.Tarot;

import java.util.ArrayList;

public record ShopDTO
        (
            ArrayList<Joker> jokers,
            ArrayList<Tarot> tarots
        ) implements ClassDTO {}
