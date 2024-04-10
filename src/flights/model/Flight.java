package flights.model;

public class Flight {

    private int flightId;
    private String flightName;
    private String flightRoute;
    private String flightDate;


    public Flight(int flightId, String flightName, String flightRoute, String flightDate) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.flightRoute = flightRoute;
        this.flightDate = flightDate;
    }
    public Flight(String text){

        String[] tokens = text.split(",");
        this.flightId = Integer.parseInt(tokens[0]);
        this.flightName = tokens[1];
        this.flightRoute = tokens[2];
        this.flightDate = tokens[3];

    }

    public int getFlightId() {return flightId;}
    public void setFlightId(int flightId) {this.flightId = flightId;}
    public String getFlightName() {return flightName;}
    public void setFlightName(String flightName) {this.flightName = flightName;}
    public String getFlightRoute() {return flightRoute;}
    public void setFlightRoute(String flightRoute) {this.flightRoute = flightRoute;}
    public String getFlightDate() {return flightDate;}
    public void setFlightDate(String flightDate) {this.flightDate = flightDate;}

    public String descriere(){

        String text = "";

        text += "Flight ID: " + this.flightId + "\n";
        text += "Flight Name: " + this.flightName + "\n";
        text += "Flight Route: " + this.flightRoute + "\n";
        text += "Flight Date: " + this.flightDate + "\n";
        return text;

    }



}
