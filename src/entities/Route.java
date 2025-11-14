package entities;

public class Route {
    private String from;
    private String to;
    private String style;

    public Route(String from, String to, String style) {
        this.from = from;
        this.to = to;
        this.style = style;
    }

    public String toString() {
        return from + " -> " + to + " (" + style + ")";
    }
}
