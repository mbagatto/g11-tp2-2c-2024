package model.reader;
import model.exceptions.CouldNotReadException;
import model.cards.Card;
import model.cards.EnglishCardBuilder;
import model.score.Score;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class EnglishCardReader {

    private final String JSON_BALATRO = "/cardsInfo/balatro.json";
    private EnglishCardBuilder builder;

    public EnglishCardReader() {
        this.builder = new EnglishCardBuilder();
    }

    public ArrayList<Card> englishCardReader() throws FileNotFoundException {

        String src = System.getProperty("user.dir") + JSON_BALATRO ;
        ArrayList<Card> cards = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(src)) {
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray deck = (JSONArray) jsonObject.get("mazo");

            for (Object key : deck) {
                JSONObject card = (JSONObject) key;
                String suit = (String) card.get("palo");
                String number = (String) card.get("numero");
                Score value = new Score((int)(long)card.get("puntos"));
                Score multiplier = new Score(Integer.parseInt((String)card.get("multiplicador")));

                if(suit.equals("Corazones")) {
                    cards.add(this.builder.createHeartCard(number, value, multiplier));
                }
                if(suit.equals("Trebol")) {
                    cards.add(this.builder.createClubCard(number, value, multiplier));
                }
                if(suit.equals("Picas")) {
                    cards.add(this.builder.createSpadeCard(number, value, multiplier));
                }
                if(suit.equals("Diamantes")) {
                    cards.add(this.builder.createDiamondCard(number, value, multiplier));
                }
            }
        } catch (Exception e) {
            throw new CouldNotReadException();
        }
        return cards;
    }
}
