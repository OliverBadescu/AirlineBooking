package bookingEnquiry.service;

import airlineEnquiry.model.AirlineEnquiry;
import bookingEnquiry.model.BookingEnquiry;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingEnquiryService {

    private ArrayList<BookingEnquiry> bookingEnquiryList;

    public BookingEnquiryService() {
        this.bookingEnquiryList = new ArrayList<>();
        this.loadData();
    }

    private void loadData() {

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\AirlineBooking\\src\\bookingEnquiry\\data\\bookingEnquiry.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                BookingEnquiry bookingEnquiry = new BookingEnquiry(line);

                this.bookingEnquiryList.add(bookingEnquiry);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findBookingEnquiryById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public BookingEnquiry findBookingEnquiryById(int id){
        for (int i =0; i < bookingEnquiryList.size();i++){
            if(bookingEnquiryList.get(i).getEnquiryId() == id){
                return bookingEnquiryList.get(i);
            }
        }
        return null;
    }

    public void addBookingEnquiry(BookingEnquiry bookingEnquiry) {
        this.bookingEnquiryList.add(bookingEnquiry);
    }

    public void afisare(){

        for(int i = 0;i < bookingEnquiryList.size();i++){
            System.out.println(bookingEnquiryList.get(i).descriere() + "\n");
        }

    }

}
