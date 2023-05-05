package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.List;


public class History {

    private final List<Order> pastOrders;

    public History(List<Order> pastOrders){
        this.pastOrders = pastOrders;
    }

    public void addOrder(Order order){
        this.pastOrders.add(order);
    }

    public List<Order> getPastOrders(){
        return this.pastOrders;
    }

    public List<Order> getFilteredOrders(Search search){
        List<Order> result = new ArrayList<>();

        for (Order order : pastOrders){
            if (search.filter(order)){
                result.add(order);
            }
        }
        return result;
    }
}
