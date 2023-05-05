package pl.edu.agh.internetshop;

public class ClientNameSearch implements Search{
    private String clientName;

    public ClientNameSearch(String name){
        this.clientName = name;
    }

    @Override
    public boolean filter(Order order){
        if (order.getClientName() != null){
            return order.getClientName().equals(this.clientName);
        }
        return false;
    }
}
