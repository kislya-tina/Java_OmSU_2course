package people;

import java.util.Objects;

public class Human{
    private String surname, name, lastname;
    private int age;
    private Gender gender;

    public Human(String surname, String name, String lastname, int age, Gender gender) {
        if(surname == null || surname.isEmpty() ||
            name == null || name.isEmpty() ||
            lastname == null || lastname.isEmpty()){
            throw new IllegalArgumentException("Trouble with full name");
        }
        if(age < 0){
            throw new IllegalArgumentException("Age would be positive");
        }
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() && getSurname().equals(human.getSurname()) && getName().equals(human.getName()) && getLastname().equals(human.getLastname()) && getGender() == human.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getName(), getLastname(), getAge(), getGender());
    }
}