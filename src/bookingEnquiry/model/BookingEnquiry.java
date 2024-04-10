package bookingEnquiry.model;

public class BookingEnquiry {

    private int enquiryId;
    private String enquiryTitle;
    private String enquiryType;
    private String enquiryDate;
    private String enquiryDescription;

    public BookingEnquiry(int id, String title, String type, String date, String description) {

        this.enquiryId = id;
        this.enquiryTitle = title;
        this.enquiryType = type;
        this.enquiryDate = date;
        this.enquiryDescription = description;


    }

    public BookingEnquiry(String text){

        String[] tokens = text.split(",");
        this.enquiryId = Integer.parseInt(tokens[0]);
        this.enquiryTitle = tokens[1];
        this.enquiryType = tokens[2];
        this.enquiryDate = tokens[3];
        this.enquiryDescription = tokens[4];


    }

    public int getEnquiryId() {return enquiryId;}
    public void setEnquiryId(int id) {this.enquiryId = id;}
    public String getEnquiryTitle() {return enquiryTitle;}
    public void setEnquiryTitle(String title) {this.enquiryTitle = title;}
    public String getEnquiryType() {return enquiryType;}
    public void setEnquiryType(String type) {this.enquiryType = type;}
    public String getEnquiryDate() {return enquiryDate;}
    public void setEnquiryDate(String date) {this.enquiryDate = date;}
    public String getEnquiryDescription() {return enquiryDescription;}
    public void setEnquiryDescription(String description) {this.enquiryDescription = description;}

    public String descriere(){

        String text = "";

        text+= "Enquiry id: " + this.enquiryId + "\n";
        text+= "Enquiry title: " + this.enquiryTitle + "\n";
        text+= "Enquiry type: " + this.enquiryType + "\n";
        text+= "Enquiry date: " + this.enquiryDate + "\n";
        text+= "Enquiry description: " + this.enquiryDescription + "\n";
        return text;

    }

}
