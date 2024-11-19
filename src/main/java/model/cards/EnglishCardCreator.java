package model.cards;

public class EnglishCardCreator {

    public Card createHearCard(int value) {
        return new Heart(value);
    }
    public Card createClubCard(int value) {
        return new Club(value);
    }
    public Card createDiamondCard(int value) {
        return new Diamond(value);
    }
    public Card createSpadeCard(int value) {
        return new Spade(value);
    }

}
