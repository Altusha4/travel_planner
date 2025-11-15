package strategy;

import entities.Route;

public class SafestRoute implements RouteStrategy{
    @Override
    public Route createRoute(String start, String end){
        return new Route(start, end, "Safest");
    }
}
