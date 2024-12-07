package view.records;

import model.ClassDTO;
import model.decks.EnglishDeck;
import model.jokers.Joker;
import model.tarots.Tarot;

import java.util.ArrayList;

public record PlayerDTO
        (
        String name,
        ArrayList<Joker> jokers,
        ArrayList<Tarot> tarots,
        EnglishDeck englishDeck
        ) implements ClassDTO {}
