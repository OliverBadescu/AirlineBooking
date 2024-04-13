package flights.model;

public class Flight {

    private int flightId;
    private int flightTickets;
    private String flightName;
    private String flightRoute;
    private String flightDate;


    public Flight(int flightId, int flightTickets, String flightName, String flightRoute, String flightDate) {
        this.flightId = flightId;
        this.flightTickets = flightTickets;
        this.flightName = flightName;
        this.flightRoute = flightRoute;
        this.flightDate = flightDate;
    }
    public Flight(String text){

        String[] tokens = text.split(",");
        this.flightId = Integer.parseInt(tokens[0]);
        this.flightTickets = Integer.parseInt(tokens[1]);
        this.flightName = tokens[2];
        this.flightRoute = tokens[3];
        this.flightDate = tokens[4];

    }

    public int getFlightId() {return flightId;}
    public void setFlightId(int flightId) {this.flightId = flightId;}
    public int getFlightTickets() {return flightTickets;}
    public void setFlightTickets(int flightTickets) {this.flightTickets = flightTickets;}
    public String getFlightName() {return flightName;}
    public void setFlightName(String flightName) {this.flightName = flightName;}
    public String getFlightRoute() {return flightRoute;}
    public void setFlightRoute(String flightRoute) {this.flightRoute = flightRoute;}
    public String getFlightDate() {return flightDate;}
    public void setFlightDate(String flightDate) {this.flightDate = flightDate;}

    public String descriere(){

        String text = "";

        text += "Flight ID: " + this.flightId + "\n";
        text += "Flight Tickets: " + this.flightTickets + "\n";
        text += "Flight Name: " + this.flightName + "\n";
        text += "Flight Route: " + this.flightRoute + "\n";
        text += "Flight Date: " + this.flightDate + "\n";
        return text;

    }



}
