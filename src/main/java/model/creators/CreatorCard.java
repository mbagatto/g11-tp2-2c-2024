package model.creators;

import model.cards.Card;
import model.score.Score;

public interface CreatorCard {
    Card createCard(String number, Score points, Score multiplier);
}
