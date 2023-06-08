package dokumenty;

import java.util.Iterator;

public class FakturaStandard extends FakturaTemplate {

    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("FA z dnia: " + faktura.getDataSprzedazy().toString());
        System.out.println("Wystawiona dla: " + faktura.getKontrahent());
    }

    @Override
    protected void drukujPozycje(Faktura faktura) {
        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
        }
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("Na kwote: "+faktura.getSuma());
    }
}