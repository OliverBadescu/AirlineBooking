package passengers.model;

public class Passanger {

    private int passengerId;
    private int ticketId;
    private String passengerName;
    private int passengerMobile;
    private String passengerEmail;
    private String passengerUsername;
    private String passengerPassword;
    private String passengerAddress;

    public Passanger(int passengerId, int ticketId, String passengerName, int passengerMobile, String passengerEmail, String passengerUsername, String passengerPassword, String passengerAddress){

        this.passengerId = passengerId;
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.passengerMobile = passengerMobile;
        this.passengerEmail = passengerEmail;
        this.passengerUsername = passengerUsername;
        this.passengerPassword = passengerPassword;
        this.passengerAddress = passengerAddress;

    }

    public Passanger(String text){

        String[] tokens = text.split(",");
        this.passengerId = Integer.parseInt(tokens[0]);
        this.ticketId = Integer.parseInt(tokens[1]);
        this.passengerName = tokens[2];
        this.passengerMobile = Integer.parseInt(tokens[3]);
        this.passengerEmail = tokens[4];
        this.passengerUsername = tokens[5];
        this.passengerPassword = tokens[6];
        this.passengerAddress = tokens[7];


    }

    public int getPassengerId() {return passengerId;}
    public void setPassengerId(int passengerId) {this.passengerId = passengerId;}
    public int getTicketId() {return ticketId;}
    public void setTicketId(int ticketId) {this.ticketId = ticketId;}
    public String getPassengerName() {return passengerName;}
    public void setPassengerName(String passengerName) {this.passengerName = passengerName;}
    public int getPassengerMobile() {return passengerMobile;}
    public void setPassengerMobile(int passengerMobile) {this.passengerMobile = passengerMobile;}
    public String getPassengerEmail() {return passengerEmail;}
    public void setPassengerEmail(String passengerEmail) {this.passengerEmail = passengerEmail;}
    public String getPassengerUsername() {return passengerUsername;}
    public void setPassengerUsername(String username) {this.passengerUsername = username;}
    public String getPassengerPassword() {return passengerPassword;}
    public void setPassengerPassword(String password) {this.passengerPassword = password;}
    public String getPassengerAddress() {return passengerAddress;}
    public void setPassengerAddress(String address) {this.passengerAddress = address;}

    public String descriere(){

        String text = "";

        text+= "Passenger id:" + passengerId + "\n";
        text+= "Ticket id:" + ticketId + "\n";
        text+= "Passenger name:" + passengerName + "\n";
        text+= "Passenger mobile:" + passengerMobile + "\n";
        text+= "Passenger email:" + passengerEmail + "\n";
        text+= "Passenger username:" + passengerUsername + "\n";
        text+= "Passenger password:" + passengerPassword + "\n";
        text+= "Passenger address:" + passengerAddress + "\n";
        return text;

    }


}
