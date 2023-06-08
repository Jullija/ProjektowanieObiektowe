package main;

import dokumenty.Faktura;
import dokumenty.FakturaEvil;
import dokumenty.FakturaStandard;
import dokumenty.FakturaTemplate;
import rabatlosowy.LosowyRabat;
import rabaty.AdapterRabatuLosowegoObiektowy;
import rabaty.ObliczCenePoRabacie;
import rabaty.ObliczCenePoRabacieKwotowym;
import rabaty.ObliczCenePoRabacieProcentowym;

public class Konfiguracja {

    private static Konfiguracja instance;
    private final ObliczCenePoRabacie obliczCenePoRabacie = new AdapterRabatuLosowegoObiektowy(new LosowyRabat());
    private final FakturaTemplate drukFaktury = new FakturaEvil();
    private final double rabatKwotowy = 10.0;
    private final double rabatProcentowy = 0.05;

    public static Konfiguracja getInstance(){
        if (instance == null){
            instance = new Konfiguracja();
        }
        return instance;
    }

    public double getRabatProcentowy(){
        return this.rabatProcentowy;
    }

    public double getRabatKwotowy(){
        return this.rabatKwotowy;
    }

    public double getBiezacyRabat(double cena){
        return obliczCenePoRabacie.obliczCenePoRabacie(cena);
    }

    public void getWydruk(Faktura faktura){
        drukFaktury.drukujFakture(faktura);
    }
}
