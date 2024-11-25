package model.reader;

import java.util.List;

public class Category {
    private String description;
    private List<JokerData> jokers;

    public List<JokerData> getJokers() {
        return jokers;
    }

    public void setJokers(List<JokerData> jokers) {
        this.jokers = jokers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


