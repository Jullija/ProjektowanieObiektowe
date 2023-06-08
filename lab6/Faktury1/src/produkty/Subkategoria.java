package produkty;

import magazyn.Towar;

import java.util.ArrayList;
import java.util.List;

public class Subkategoria implements ICategory {
    private String name;
    private List<Towar> components = new ArrayList<Towar>();

    public Subkategoria(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(Towar component) {
        components.add(component);
    }

    public void print() {
        System.out.println("Podkategoria: " + name + ".");
        System.out.println("Elementy w podkategorii: ");
        for (Towar towar : components) {
            System.out.println(towar.getNazwa() + " ");;
        }
        System.out.println("...........");
    }
}
