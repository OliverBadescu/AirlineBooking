package airlineEnquiry.service;

import airlineBooking.model.AirlineBooking;
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

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findAirlineEnquiryById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public AirlineEnquiry findAirlineEnquiryById(int id){
        for (int i =0; i < airlineEnquiryList.size();i++){
            if(airlineEnquiryList.get(i).getAirlineEnquiryId() == id){
                return airlineEnquiryList.get(i);
            }
        }
        return null;
    }

    public void addAirlineEnquiry(AirlineEnquiry airlineEnquiry){
        this.airlineEnquiryList.add(airlineEnquiry);
    }

    public void afisare(){
        for(int i =0; i < airlineEnquiryList.size();i++){
            System.out.println(airlineEnquiryList.get(i).descriere() + "\n");
        }
    }

}
