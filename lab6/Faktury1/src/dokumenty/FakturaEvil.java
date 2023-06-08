package dokumenty;

import java.util.Iterator;

public class FakturaEvil extends FakturaTemplate{
    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("Na kwote: "+faktura.getSuma());
    }

    @Override
    protected void drukujPozycje(Faktura faktura) {
        System.out.println("FA z dnia: " + faktura.getDataSprzedazy().toString());
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("Wystawiona dla: " + faktura.getKontrahent());
        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
        }
    }
}
