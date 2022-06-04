package people;

import java.util.Objects;

public class Student extends Human{
    private String university, faculty, speciality;
    public Student(String surname, String name, String lastname, int age, Gender gender,
                     String university, String faculty, String speciality) {
        super(surname, name, lastname, age, gender);
        if(university == null || university.isEmpty() ||
                faculty == null || faculty.isEmpty() ||
                speciality == null || speciality.isEmpty()){
            throw new IllegalArgumentException("Incorrect study place");
        }
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return getUniversity().equals(student.getUniversity()) && getFaculty().equals(student.getFaculty()) && getSpeciality().equals(student.getSpeciality());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUniversity(), getFaculty(), getSpeciality());
    }
}
