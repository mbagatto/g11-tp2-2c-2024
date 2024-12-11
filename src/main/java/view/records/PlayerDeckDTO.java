package view.records;

import model.ClassDTO;
import model.cards.Card;
import java.util.ArrayList;

public record PlayerDeckDTO
        (
        ArrayList<Card> cards,
        HandDTO handDTO
        ) implements ClassDTO {}
