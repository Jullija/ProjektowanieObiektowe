package pl.edu.agh.internetshop;

import java.util.List;

public class ProductNameSearch  implements Search{
    private String name;

    public ProductNameSearch(String name){
        this.name = name;
    }

    @Override
    public boolean filter(Order order){
        List<Product> products = order.getProducts();
        for (Product prod: products){
            if (prod.getName().equals(this.name)){
                return true;
            }
        }
        return false;
    }
}
