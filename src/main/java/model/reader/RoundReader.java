package model.reader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.game.NullRound;
import model.score.Score;
import model.tarots.Tarot;
import model.game.Round;
import model.game.Shop;
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

            for(int i = 0; i < roundData.size(); i++) {
                Round round = this.roundGenerator(roundData.get(i));
                if (i != 0) {
                    this.rounds.get(i - 1).setNextRound(round);
                } else if (i == roundData.size() - 1) {
                    round.setNextRound(new NullRound());
                }
                this.rounds.add(round);
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
        Shop shop = this.shopGenerator(storeData);
        return (new Round(number, hands, discards, scoreToBeat, shop));
    }

    public Shop shopGenerator(StoreData storeData) {
        Shop shop = new Shop();
//        EnglishCardData cardData = storeData.getEnglishCardData();

        JokerDeck jokerDeck = new JokerDeck();
        jokerDeck.fillDeck();
        for (JokerData jokerData : storeData.getJokers()) {
            Joker joker = jokerDeck.findJokerByName(jokerData.getName());
            shop.addJoker(joker);
        }

        TarotDeck tarotDeck = new TarotDeck();
        tarotDeck.fillDeck();
        for (TarotData tarotData : storeData.getTarots()) {
            Tarot tarot = tarotDeck.findTarotByName(tarotData.getName());
            shop.addTarot(tarot);
        }
//        EnglishCardParser englishCardParser = new EnglishCardParser();
//        Card card = englishCardParser.cardGenerator(cardData);
        return shop;
    }
}
