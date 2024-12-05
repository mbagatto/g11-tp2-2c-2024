package model.creators;

import model.cards.*;
import model.score.Score;

public class EnglishCardBuilder {
    public Card createHeartCard(String number, Score value, Score multiplier) {
        return new Heart(number, value, multiplier);
    }

    public Card createClubCard(String number, Score value, Score multiplier) {
        return new Club(number, value, multiplier);
    }

    public Card createDiamondCard(String number, Score value, Score multiplier) {
        return new Diamond(number, value, multiplier);
    }

    public Card createSpadeCard(String number, Score value, Score multiplier) {
        return new Spade(number, value, multiplier);
    }
}
