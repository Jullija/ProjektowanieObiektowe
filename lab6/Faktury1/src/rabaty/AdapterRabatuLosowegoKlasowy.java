package rabaty;

import rabatlosowy.LosowyRabat;

public class AdapterRabatuLosowegoKlasowy extends LosowyRabat implements  ObliczCenePoRabacie {
    @Override
    public double obliczCenePoRabacie (double cena){
        cena -= cena * losujRabat()/10;
        return cena;
    }
}
