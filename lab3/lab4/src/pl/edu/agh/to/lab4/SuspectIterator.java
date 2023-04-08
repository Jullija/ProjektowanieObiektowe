package pl.edu.agh.to.lab4;

import java.util.Iterator;
import java.util.NoSuchElementException;

//Iterator with Suspect's collection or inherited classes
//implemented methods for iterator and how it should work

public class SuspectIterator implements Iterator<Suspect> {
    Suspect sus;
    Iterator<? extends Suspect> iterator;

    public SuspectIterator(Iterator<? extends Suspect > iterator){
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext(){
        return iterator.hasNext();
    }

    @Override
    public Suspect next(){
        sus = iterator.next();
        if (sus != null){
            return sus;
        }
        throw new NoSuchElementException("No such element");
    }
}
