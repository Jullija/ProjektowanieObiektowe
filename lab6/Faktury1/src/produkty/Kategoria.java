package produkty;

import magazyn.Towar;

import java.util.ArrayList;
import java.util.List;

public class Kategoria implements ICategory{
    private String name;
    private List<Towar> components = new ArrayList<Towar>();

    public Kategoria(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Kategoria: " + name + ".");
        System.out.println("Elementy w kategorii: ");
        for (Towar towar : components){
            System.out.println(towar.getNazwa() + " ");
        }
        System.out.println("...........");

    }

    public void addComponent(Towar component) {
        components.add(component);
    }
}
