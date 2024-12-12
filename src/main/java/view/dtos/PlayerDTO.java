package view.dtos;

import model.decks.EnglishDeck;
import model.decks.PlayerDeck;
import model.jokers.Joker;
import model.tarots.Tarot;

import java.util.ArrayList;

public record PlayerDTO
        (
                String name,
                ArrayList<Joker> jokers,
                ArrayList<Tarot> tarots,
                EnglishDeck englishDeck,
                PlayerDeck playerDeck
        ) implements ClassDTO {}
