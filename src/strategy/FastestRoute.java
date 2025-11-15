package strategy;

import entities.Route;

public class FastestRoute implements RouteStrategy{
    @Override
    public Route createRoute(String start, String end){
        return new Route(start, end, "Fastest");
    }
}
