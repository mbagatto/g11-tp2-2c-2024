package model.reader;

// Este archivo no se si anda pero bueno copie del EnglishCardReader y del EnglishCardCreator hecho por David
// No se como se deberia testear
import model.creators.JokerCreator;
import model.exceptions.CouldNotReadException;
import model.jokers.Joker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class JokerReader {

    private final String JSON_JOKER = "/cardsInfo/comodines.json";
    private JokerCreator creator;

    public JokerReader() {
        this.creator = new JokerCreator();
    }

    public ArrayList<Joker> jokerReader() throws FileNotFoundException {

        String src = System.getProperty("user.dir") + JSON_JOKER;
        ArrayList<Joker> jokers = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(src)) {
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;


            for (Object categoryKey : jsonObject.keySet()) { //Este for itera las categorias
                JSONObject category = (JSONObject) jsonObject.get(categoryKey);

                String categoryDescription = (String) category.get("descripcion"); //Primera descripcion que creo no se usa

                JSONArray jokersArray = (JSONArray) category.get("comodines");

                for (Object key : jokersArray) { //Este for itera dentro de la categoria que estee por joker

                    JSONObject joker = (JSONObject) key;

                    //Estas son las variables que obtiene del JSON //CREO//
                    String name = (String) joker.get("nombre");
                    String description = (String) joker.get("descripcion");
                    String activation = (String) joker.get("activacion");
                    JSONObject effect = (JSONObject) joker.get("efecto");
                    int points = Math.toIntExact((Long) effect.get("puntos"));
                    int multiplicator = Math.toIntExact((Long) effect.get("multiplicador"));

                    if (categoryKey.equals("Al Puntaje")) {
                        jokers.add(this.creator.createForTheScore(name, description, activation, points, multiplicator)); //Este labura con el creator de Joker
                    }
                    //Falta hacer para todos los Jokers.. Seguiria debajo de esta linea
                }
            }
        } catch (Exception e) {
            throw new CouldNotReadException();
        }
        return jokers;
    }
}
