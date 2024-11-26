package model.reader;

import java.util.ArrayList;

public interface Reader<T> {
    ArrayList<T> read();
}
