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
    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public String getStyle() {
        return style;
    }
    public String toString() {
        return "Route: " + from + " -> " + to + " (" + style + ")";
    }
}
