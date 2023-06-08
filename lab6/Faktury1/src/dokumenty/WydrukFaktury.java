package dokumenty;

import main.Konfiguracja;

import java.util.Iterator;

public class WydrukFaktury {
    public static void drukujFakture(Faktura faktura){
        Konfiguracja konfiguracja = Konfiguracja.getInstance();
        konfiguracja.getWydruk(faktura);
    }
}
