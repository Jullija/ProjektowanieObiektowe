package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Prisoner extends Suspect{
    private final int judgementYear;

    private final int senteceDuration;

    private final String pesel;

    private final String firstname;

    private final String surname;

    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        this.firstname = name;
        this.surname = surname;
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
    }

    public int getAge() {


    }

    public boolean isJailedNow() {
        return judgementYear + senteceDuration >= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

}
