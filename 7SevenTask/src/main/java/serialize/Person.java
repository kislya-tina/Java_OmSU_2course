package serialize;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Person implements Serializable {
    private String surname;
    private String name;
    private String lastname;
    private String birth;

    public Person(){}

    public Person(String surname, String name, String lastname, String birth) {
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.birth = birth;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirth() {
        return birth;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getSurname().equals(person.getSurname()) &&
                getName().equals(person.getName()) &&
                getLastname().equals(person.getLastname())
                && getBirth().equals(person.getBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getName(), getLastname(), getBirth());
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
