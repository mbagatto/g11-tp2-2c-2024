package model.reader;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JokerData {
    @JsonProperty("nombre")
    private String name;

    @JsonProperty("descripcion")
    private String description;

    @JsonProperty("activacion")
    private Object activation;

    @JsonProperty("efecto")
    private Effect effect;

    @JsonProperty("comodines")
    private List<JokerData> jokers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getActivation() {
        return activation;
    }

    public void setActivation(Object activation) {
        this.activation = activation;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public List<JokerData> getJokers() {
        return jokers;
    }

    public void setJokers(List<JokerData> jokers) {
        this.jokers = jokers;
    }
}

