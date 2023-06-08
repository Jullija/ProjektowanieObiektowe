package rabaty;

import rabatlosowy.LosowyRabat;

public class AdapterRabatuLosowegoObiektowy implements  ObliczCenePoRabacie{

    private final LosowyRabat losowyRabat;

    public AdapterRabatuLosowegoObiektowy(LosowyRabat losowyRabat){
        this.losowyRabat = losowyRabat;
    }
    @Override
    public double obliczCenePoRabacie (double cena){
        cena -= cena * losowyRabat.losujRabat()/10;
        return cena;
    }
}
