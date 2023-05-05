package pl.edu.agh.internetshop;

import java.util.List;

public class MultipleSearch implements Search{
    private final List<Search> filters;

    public MultipleSearch(List<Search> filters){
        this.filters = filters;
    }

    @Override
    public boolean filter(Order order){
        return filters.stream().allMatch(f -> f.filter(order));
    }
}
