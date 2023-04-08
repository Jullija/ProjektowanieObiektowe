package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Finder {
    private final SuspectAggregate allPersons;

    private final SuspectAggregate allPrisoners;

    public Finder(PersonDataProvider persondp, PrisonersDatabase prisondb) {
        this.allPersons = persondp;
        this.allPrisoners = prisondb;
    }


    public void displayAllSuspectsWithName(String name) {
        ArrayList<Suspect> suspected = new ArrayList<Suspect>();
        Iterator<? extends Suspect> prisonersIterator = allPrisoners.iterator();
        Iterator<? extends Suspect> personsIterator = allPersons.iterator();

        Suspect temp = null;
        while (prisonersIterator.hasNext()){
            temp = prisonersIterator.next();
            if(temp.canBeAccused() && temp.getFirstName().equals(name)){
                suspected.add(temp);
                if (suspected.size() >= 10){
                    break;
                }
            }
        }

       if (suspected.size() < 10){
           while (personsIterator.hasNext()){
               temp = personsIterator.next();
               if (temp.canBeAccused() && temp.getFirstName().equals(name)){
                   suspected.add(temp);
                   if (suspected.size() >= 10){
                       break;
                   }
               }
           }
       }

        System.out.println("Znalazlem " + suspected.size() + " pasujacych podejrzanych!");

        for (Suspect sus : suspected) {
            System.out.println(sus.display());
        }

    }
}
