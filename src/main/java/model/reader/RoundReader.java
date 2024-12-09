package model.reader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.score.Score;
import model.tarots.Tarot;
import model.game.Round;
import model.game.Shop;
import model.cards.Card;
import model.decks.JokerDeck;
import model.decks.TarotDeck;
import model.exceptions.CouldNotReadException;
import model.jokers.Joker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RoundReader {

    private ArrayList<Round> rounds;

    public RoundReader() {
        this.rounds = new ArrayList<>();
    }

    public ArrayList<Round> read(String pathRound) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            File file = new File(System.getProperty("user.dir") + pathRound);
            BalatroData balatroData = objectMapper.readValue(file, BalatroData.class);
            List<RoundData> roundData = balatroData.getRounds();

            for(RoundData round : roundData) {
                this.rounds.add(this.roundGenerator(round));
            }

        } catch (Exception e) {
            throw new CouldNotReadException();
        }
        return this.rounds;
    }

    public Round roundGenerator(RoundData round) {
        int number = round.getNumber();
        Score hands = new Score(round.getHands());
        Score discards = new Score(round.getDiscards());
        Score scoreToBeat  = new Score(round.getScoreToBeat());
        StoreData storeData = round.getStore();
        Shop shop = this.storeGenerator(storeData);
        return (new Round(number, hands, discards, scoreToBeat, shop));
    }

    public Shop storeGenerator(StoreData storeData) {
        List<JokerData> jokers = storeData.getJokers();
        List<TarotData> tarots = storeData.getTarots();
        EnglishCardData cardData = storeData.getEnglishCardData();

        ArrayList<Joker> realJokers = new ArrayList<>();
        JokerDeck jokerDeck = new JokerDeck();
        jokerDeck.fillDeck();
        for (JokerData jokerData : jokers) {
            Joker actualJoker = jokerDeck.findJokerByName(jokerData.getName());
            if (actualJoker != null) {
                realJokers.add(actualJoker);
            }
        }

        ArrayList<Tarot> realTarots = new ArrayList<>();
        TarotDeck tarotDeck = new TarotDeck();
        tarotDeck.fillDeck();
        for (TarotData tarotData : tarots) {
            Tarot actualTarot = tarotDeck.findTarotByName(tarotData.getName());
            if (actualTarot != null) {
                realTarots.add(actualTarot);
            }
        }
        EnglishCardParser englishCardParser = new EnglishCardParser();
        Card card = englishCardParser.cardGenerator(cardData);
        return (new Shop(realJokers, realTarots, card));
    }
}
