package serialize;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {
    private int number;
    private double square;
    private List<Person> people;

    public Flat(){}

    @Override
    public String toString() {
        return "Flat{" +
                "number=" + number +
                ", square=" + square +
                ", people=" + people +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat)) return false;
        Flat flat = (Flat) o;
        return getNumber() == flat.getNumber() && Double.compare(flat.getSquare(), getSquare()) == 0 && getPeople().equals(flat.getPeople());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getSquare(), getPeople());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Flat(int number, double square, List<Person> people) {
        this.number = number;
        this.square = square;
        this.people = people;
    }
}
