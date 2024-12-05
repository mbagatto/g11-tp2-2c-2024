package model.reader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.cards.Card;
import model.creators.EnglishCardBuilder;
import model.exceptions.CouldNotReadException;
import model.score.Score;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EnglishCardParser {

    private EnglishCardBuilder creator;

    public EnglishCardParser() {
        this.creator = new EnglishCardBuilder();
    }

    public ArrayList<Card> read(String pathEnglishCard ) {

        ArrayList<Card> englishCards = new ArrayList<>();

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            File file = new File(System.getProperty("user.dir") + pathEnglishCard);
            BalatroData balatroData = objectMapper.readValue(file, BalatroData.class);
            List<EnglishCardData> cardData = balatroData.getDeck();

            for(EnglishCardData englishCardData : cardData) {
                englishCards.add(this.cardGenerator(englishCardData));
            }

        }catch (Exception e){
            throw new CouldNotReadException();
        }
        return englishCards;
    }

    public Card cardGenerator(EnglishCardData jsonCard) {

        String suit = jsonCard.getSuit();
        String number = jsonCard.getNumber();
        Score points =  new Score(jsonCard.getPoints()) ;
        Score multiplier = new Score(jsonCard.getMultiplier());
        Card card = null;

        switch(suit) {
            case "Trebol":
                card = this.creator.createClubCard(number,points,multiplier);
                break;
            case "Corazones":
                card = this.creator.createHeartCard(number,points,multiplier);
                break;
            case "Picas":
                card = this.creator.createSpadeCard(number,points,multiplier);
                break;
            case "Diamantes":
                card = this.creator.createDiamondCard(number,points,multiplier);
                break;
        }
        return card;
    }
}
