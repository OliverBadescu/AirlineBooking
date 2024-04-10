package tickets.model;

public class Ticket {

    private int ticketId;
    private int passengerId;
    private String ticketType;
    private String ticketDate;
    private String ticketDescription;

    public Ticket(int ticketId, int passengerId, String ticketType, String ticketDate, String ticketDescription) {

        this.ticketId = ticketId;
        this.passengerId = passengerId;
        this.ticketType = ticketType;
        this.ticketDate = ticketDate;
        this.ticketDescription = ticketDescription;

    }

    public Ticket (String text){

        String[] tokens = text.split(",");
        this.ticketId = Integer.parseInt(tokens[0]);
        this.passengerId = Integer.parseInt(tokens[1]);
        this.ticketType = tokens[2];
        this.ticketDate = tokens[3];
        this.ticketDescription = tokens[4];

    }

    public int getTicketId() {return ticketId;}
    public void setTicketId(int ticketId) {this.ticketId = ticketId;}
    public int getPassengerId() {return passengerId;}
    public void setPassengerId(int passengerId) {this.passengerId = passengerId;}
    public String getTicketType() {return ticketType;}
    public void setTicketType(String ticketType) {this.ticketType = ticketType;}
    public String getTicketDate() {return ticketDate;}
    public void setTicketDate(String ticketDate) {this.ticketDate = ticketDate;}
    public String getTicketDescription() {return ticketDescription;}
    public void setTicketDescription(String ticketDescription) {this.ticketDescription = ticketDescription;}

    public String desciere(){

        String text = "";

        text += "Ticket ID: " + ticketId + "\n";
        text += "Passenger ID: " + passengerId + "\n";
        text += "Ticket Type: " + ticketType + "\n";
        text += "Ticket Date: " + ticketDate + "\n";
        text += "Ticket Description: " + ticketDescription + "\n";
        return text;

    }


}
