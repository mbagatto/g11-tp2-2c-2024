package model;

public class Diamond {
    @Override
    public boolean equals(Object o) {
        return (o instanceof Diamond);
    }
}
