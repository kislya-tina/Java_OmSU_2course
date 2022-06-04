package serialize;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    private String kNumber;
    private String address;
    private Person headPerson;
    private List<Flat> flats;

    public House(){}

    public House(String kNumber, String address, Person headPerson, List<Flat> flats) {
        this.kNumber = kNumber;
        this.address = address;
        this.headPerson = headPerson;
        this.flats = flats;
    }

    @Override
    public String toString() {
        return "House{" +
                "kNumber='" + kNumber + '\'' +
                ", address='" + address + '\'' +
                ", headPerson=" + headPerson +
                ", flats=" + flats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        House house = (House) o;
        return getkNumber().equals(house.getkNumber()) && getAddress().equals(house.getAddress()) && getHeadPerson().equals(house.getHeadPerson()) && getFlats().equals(house.getFlats());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getkNumber(), getAddress(), getHeadPerson(), getFlats());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getHeadPerson() {
        return headPerson;
    }

    public void setHeadPerson(Person headPerson) {
        this.headPerson = headPerson;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    public String getkNumber() {
        return kNumber;
    }

    public void setkNumber(String kNumber) {
        this.kNumber = kNumber;
    }
}
