package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PersonDataProvider implements SuspectAggregate {

    private final Collection<CracovCitizen> cracovCitizens = new ArrayList<CracovCitizen>();

    public PersonDataProvider(){generateDatabase();}
    public void addCitizen(String firstname, String lastname, int age){
        this.cracovCitizens.add(new CracovCitizen(firstname, lastname, age));
    }

    public void generateDatabase() {
        addCitizen("Jan", "Kowalski", 30);
        addCitizen("Janusz", "Krakowski", 30);
        addCitizen("Janusz", "Mlodociany", 10);
        addCitizen("Kasia", "Kosinska", 19);
        addCitizen("Piotr", "Zgredek", 29);
        addCitizen("Tomek", "Gimbus", 14);
        addCitizen("Janusz", "Gimbus", 15);
        addCitizen("Alicja", "Zaczarowana", 22);
        addCitizen("Janusz", "Programista", 77);
        addCitizen("Pawel", "Pawlowicz", 32);
        addCitizen("Krzysztof", "Mendel", 30);
    }

    public Collection<CracovCitizen> getAllCracovCitizens() {
        return cracovCitizens;
    }

    @Override
    public Iterator<Suspect> iterator(){
        return new SuspectIterator(cracovCitizens.iterator());
    }

}
