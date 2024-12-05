package view.records;

import model.jokers.Joker;
import model.tarots.Tarot;

import java.util.List;

public record PlayerRecord(    String name,
                               PlayerDeckRecord playerDeck,
                               List<Joker> jokers,
                               List<Tarot> tarots,
                               ScoreRecord discardsScore) {
}
