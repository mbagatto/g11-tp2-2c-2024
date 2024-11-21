package model.reader;
import model.CouldNotReadException;
import model.cards.Card;
import model.cards.EnglishCardCreator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;


public class EnglishCardReader {

    private final String JSON_BALATRO = "/cardsInfo/balatro.json";
    private EnglishCardCreator creator;

    public EnglishCardReader() {
        this.creator = new EnglishCardCreator();
    }

    public ArrayList<Card> englishCardReader() throws FileNotFoundException {

        String src = System.getProperty("user.dir") + JSON_BALATRO ;
        ArrayList<Card> cards = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(src)){

            Object obj = jsonParser.parse(fileReader);

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray deck = (JSONArray) jsonObject.get("mazo");

            for(Object key : deck) {

                JSONObject card = (JSONObject) key;

                String name = (String) card.get("nombre");
                String suit = (String) card.get("palo");
                String number = (String) card.get("numero");
                int value =  Math.toIntExact((Long) card.get("puntos"));
                int multiplier = Integer.parseInt((String) card.get("multiplicador"));

                if(Objects.equals(suit, "Corazones")){
                    cards.add(this.creator.createHearCard(name,number,value,multiplier));
                }
                if(Objects.equals(suit, "Trebol")){
                    cards.add(this.creator.createClubCard(name,number,value,multiplier));
                }
                if(Objects.equals(suit, "Picas")){
                    cards.add(this.creator.createSpadeCard(name,number,value,multiplier));
                }
                if(Objects.equals(suit, "Diamantes")){
                    cards.add(this.creator.createDiamondCard(name,number,value,multiplier));
                }
            }

        } catch (Exception e) {
            throw new CouldNotReadException();
        }
        return cards;
    }


}
