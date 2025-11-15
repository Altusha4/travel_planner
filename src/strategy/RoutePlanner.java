package strategy;

import entities.Route;

public class RoutePlanner {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy strategy){
        this.strategy = strategy;
    }
    public Route buildRoute(String start, String end){
        if(strategy == null){
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.createRoute(start, end);
    }
}
