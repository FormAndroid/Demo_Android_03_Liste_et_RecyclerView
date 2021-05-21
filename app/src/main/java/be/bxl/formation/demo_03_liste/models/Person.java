package be.bxl.formation.demo_03_liste.models;

public class Person {

    public enum Gender {
        MALE,
        FEMALE
    };

    private String firstname;
    private String lastname;
    private Gender gender;

    public Person(String firstname, String lastname, Gender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return getFirstname() + " " + getLastname().toUpperCase();
    }
}
