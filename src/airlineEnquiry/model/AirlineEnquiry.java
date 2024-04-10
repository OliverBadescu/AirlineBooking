package airlineEnquiry.model;

public class AirlineEnquiry {

    private int airlineEnquiryId;
    private String airlineEnquiryTitle;
    private String airlineEnquiryType;
    private String airlineEnquiryDate;
    private String airlineEnquiryDescription;


    public AirlineEnquiry(int airlineEnquiryId, String airlineEnquiryTitle, String airlineEnquiryType, String airlineEnquiryDate, String airlineEnquiryDescription) {

        this.airlineEnquiryId = airlineEnquiryId;
        this.airlineEnquiryTitle = airlineEnquiryTitle;
        this.airlineEnquiryType = airlineEnquiryType;
        this.airlineEnquiryDate = airlineEnquiryDate;
        this.airlineEnquiryDescription = airlineEnquiryDescription;

    }

    public AirlineEnquiry(String text) {

        String[] tokens = text.split(",");
        this.airlineEnquiryId = Integer.parseInt(tokens[0]);
        this.airlineEnquiryTitle = tokens[1];
        this.airlineEnquiryType = tokens[2];
        this.airlineEnquiryDate = tokens[3];
        this.airlineEnquiryDescription = tokens[4];



    }
    public int getAirlineEnquiryId() {return airlineEnquiryId;}
    public void setAirlineEnquiryId(int airlineEnquiryId) {this.airlineEnquiryId = airlineEnquiryId;}
    public String getAirlineEnquiryTitle() {return airlineEnquiryTitle;}
    public void setAirlineEnquiryTitle(String airlineEnquiryTitle) {this.airlineEnquiryTitle = airlineEnquiryTitle;}
    public String getAirlineEnquiryType() {return airlineEnquiryType;}
    public void setAirlineEnquiryType(String airlineEnquiryType){this.airlineEnquiryType = airlineEnquiryType;}
    public String getAirlineEnquiryDate() {return airlineEnquiryDate;}
    public void setAirlineEnquiryDate(String airlineEnquiryDate){this.airlineEnquiryDate = airlineEnquiryDate;}
    public String getAirlineEnquiryDescription() {return airlineEnquiryDescription;}
    public void setAirlineEnquiryDescription(String airlineEnquiryDescription){this.airlineEnquiryDescription = airlineEnquiryDescription;}

    public String descriere(){

        String text = "";

        text += "Airline Enquiry ID: " + this.airlineEnquiryId + "\n";
        text += "Airline Enquiry Title: " + this.airlineEnquiryTitle + "\n";
        text += "Airline Enquiry Type: " + this.airlineEnquiryType + "\n";
        text+= "Airline Enquiry Date: " + this.airlineEnquiryDate + "\n";
        text += "Airline Enquiry Description: " + this.airlineEnquiryDescription;
        return text;
    }

}
