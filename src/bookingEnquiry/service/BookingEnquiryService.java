package bookingEnquiry.service;

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

}
