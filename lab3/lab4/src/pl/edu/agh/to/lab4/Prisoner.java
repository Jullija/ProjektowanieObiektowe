package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Prisoner extends Suspect{
    private final int judgementYear;

    private final int senteceDuration;

    private final String pesel;


    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        super(name, surname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
    }

    public int getAge() { //take two first
        int peselInt = Integer.parseInt(pesel);
        peselInt /= 1000000000;
        return getCurrentYear() - peselInt;
    }

   @Override
    public boolean canBeAccused() {
        return judgementYear + senteceDuration <= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

}
