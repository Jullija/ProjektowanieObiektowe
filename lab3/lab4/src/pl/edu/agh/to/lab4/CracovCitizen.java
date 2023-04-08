package pl.edu.agh.to.lab4;

public class CracovCitizen extends Suspect{
    private String firstname;

    private String lastname;

    private int age;

    public CracovCitizen(String firstname, String lastname, int age) {
        super(firstname, lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean canBeAccused() {
        return age >= 18;
    }
}
