package view.records;

public record RoundRecord(int number,
                          int hands,
                          int discards,
                          ScoreRecord scoreToBeat,
                          ScoreRecord actualScore) {
}
