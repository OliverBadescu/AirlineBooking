package airlineBooking.model;

public class AirlineBooking {

    private int bookingId;
    private int passengerId;
    private String bookingType;
    private String bookingDate;
    private String bookingDescription;

    public AirlineBooking(int bookingId, int passengerId, String bookingType, String bookingDate, String bookingDescription) {

        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.bookingType = bookingType;
        this.bookingDate = bookingDate;
        this.bookingDescription = bookingDescription;

    }

    public AirlineBooking(String text) {

        String[] tokens = text.split(",");
        this.bookingId = Integer.parseInt(tokens[0]);
        this.passengerId = Integer.parseInt(tokens[1]);
        this.bookingType = tokens[2];
        this.bookingDate = tokens[3];
        this.bookingDescription = tokens[4];

    }

    public int getBookingId() {return bookingId;}
    public void setBookingId(int bookingId) {this.bookingId = bookingId;}
    public int getPassengerId() {return passengerId;}
    public void setPassengerId(int passengerId) {this.passengerId = passengerId;}
    public String getBookingType() {return bookingType;}
    public void setBookingType(String bookingType) {this.bookingType = bookingType;}
    public String getBookingDate() {return bookingDate;}
    public void setBookingDate(String bookingDate) {this.bookingDate = bookingDate;}
    public String getBookingDescription() {return bookingDescription;}
    public void setBookingDescription(String bookingDescription) {this.bookingDescription = bookingDescription;}

    public String descriere(){

        String text = "";

        text += "Booking ID: " + bookingId + "\n";
        text += "Passenger ID: " + passengerId + "\n";
        text += "Booking Type: " + bookingType + "\n";
        text += "Booking Date: " + bookingDate + "\n";
        text += "Booking Description: " + bookingDescription + "\n";
        return text;
    }



}
