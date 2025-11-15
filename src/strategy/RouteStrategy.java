package strategy;
import entities.Route;

public interface RouteStrategy {
    Route createRoute(String start, String end);
}
