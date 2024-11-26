package model.reader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.cards.Card;
import model.cards.EnglishCardBuilder;
import model.exceptions.CouldNotReadException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EnglishCardParser implements Parser {
    private EnglishCardCreator creator;

    public EnglishCardParser() {
        this.creator = new EnglishCardCreator();
    }

    public ArrayList<Card> parser(String pathEnglishCard ) {

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

//        JSONParser jsonParser = new JSONParser();
//
//        try(FileReader fileReader = new FileReader( System.getProperty("user.dir") + pathEnglishCard)){
//            Object obj = jsonParser.parse(fileReader);
//            JSONObject jsonObject = (JSONObject) obj;
//            JSONArray jsonDeck = (JSONArray) jsonObject.get("mazo");
//
//            for (Object card : jsonDeck) {
//                JSONObject jsonCard = (JSONObject) card;
//                Card toAdd = this.cardGenerator(jsonCard);
//                englishCard.add(toAdd);
//            }
//
//        }catch (Exception e){
//            throw new CouldNotReadException();
//        }

        return englishCards;
    }

    private Card cardGenerator(JSONObject jsonCard) {

        String name = (String) jsonCard.get("nombre");
        String suit = (String) jsonCard.get("palo");
        String number = (String) jsonCard.get("numero");
        int value =  Math.toIntExact((Long) jsonCard.get("puntos"));
        int multiplier = Integer.parseInt((String) jsonCard.get("multiplicador"));

        return this.creator.createEnglishCard(suit,name,number,value,multiplier);
//        if(Objects.equals(suit, "Corazones")){
//            return this.creator.createHearCard(name,number,value,multiplier);
//        }
//        if(Objects.equals(suit, "Trebol")){
//            return this.creator.createClubCard(name,number,value,multiplier);
//        }
//        if(Objects.equals(suit, "Picas")){
//            return this.creator.createSpadeCard(name,number,value,multiplier);
//        }
//        if(Objects.equals(suit, "Diamantes")){
//            return this.creator.createDiamondCard(name,number,value,multiplier);
//        }

    }

    private Card cardGenerator(EnglishCardData jsonCard) {

        String name = jsonCard.getName();
        String suit = jsonCard.getSuit();
        String number = jsonCard.getNumber();
        int value =  jsonCard.getPoints();
        int multiplier = jsonCard.getMultiplier();

        return this.creator.createEnglishCard(suit,name,number,value,multiplier);

    }

}
