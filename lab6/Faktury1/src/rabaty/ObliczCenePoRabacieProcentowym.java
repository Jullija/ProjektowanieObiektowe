package rabaty;

import main.Konfiguracja;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie{


    @Override
    public double obliczCenePoRabacie(double cena) {
        Konfiguracja k = Konfiguracja.getInstance();
        return cena * (1-Konfiguracja.getInstance().getRabatProcentowy());
    }
}
