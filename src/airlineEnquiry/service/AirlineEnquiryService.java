package airlineEnquiry.service;

import airlineEnquiry.model.AirlineEnquiry;
import bookingEnquiry.model.BookingEnquiry;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AirlineEnquiryService {

    private ArrayList<AirlineEnquiry> airlineEnquiryList;

    public AirlineEnquiryService() {
        this.airlineEnquiryList = new ArrayList<>();
        this.loadData();
    }

    private void loadData() {

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\AirlineBooking\\src\\airlineEnquiry\\data\\airlineEnquiry.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                AirlineEnquiry airlineEnquiry = new AirlineEnquiry(line);

                this.airlineEnquiryList.add(airlineEnquiry);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
