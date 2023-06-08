package dokumenty;

public abstract class FakturaTemplate {

    public void drukujFakture(Faktura faktura) {
        drukujNaglowek(faktura);
        drukujPozycje(faktura);
        drukujStopke(faktura);
    }

    protected abstract void drukujNaglowek(Faktura faktura);

    protected abstract void drukujPozycje(Faktura faktura);

    protected abstract void drukujStopke(Faktura faktura);

}