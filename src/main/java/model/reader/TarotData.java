package model.reader;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TarotData {

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("descripcion")
    private String description;

    @JsonProperty("efecto")
    private Effect effect;

    @JsonProperty("sobre")
    private String about;

    @JsonProperty("ejemplar")
    private String exampler;

    public String getName() {
        return this.name;
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

    public Effect getEfecto() {
        return this.effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public String getAbout() {
        return this.about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getExampler() {
        return this.exampler;
    }

    public void setExampler(String exampler) {
        this.exampler = exampler;
    }
}
