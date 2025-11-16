package entities;

import entities.transport.Transport;

public class Route {
    private String from;
    private String to;
    private String style;
    private Transport transport;

    public Route(String from, String to, String style) {
        this.from = from;
        this.to = to;
        this.style = style;
        this.transport = null;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        String transportInfo = "";
        if (transport != null) {
            transportInfo = " | transport: " + transport.getType()
                    + " (" + transport.getSpeed() + " km/h)";
        }
        return from + " -> " + to + " (" + style + ")" + transportInfo;
    }
}