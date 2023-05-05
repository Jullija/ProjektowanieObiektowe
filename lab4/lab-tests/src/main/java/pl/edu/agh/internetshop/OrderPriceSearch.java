package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.List;

public class OrderPriceSearch implements Search{

    private BigDecimal price;

    public OrderPriceSearch(BigDecimal price){
        this.price = price;
    }

    @Override
    public boolean filter(Order order){
       return order.getPriceWithTaxes().compareTo(this.price) == 0;
    }
}
