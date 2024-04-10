package airlineBooking.service;

import airlineBooking.model.AirlineBooking;
import airlineEnquiry.model.AirlineEnquiry;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AirlineBookingService {

    private ArrayList<AirlineBooking> airlineBookings;

    public AirlineBookingService() {
        this.airlineBookings = new ArrayList<>();
        this.loadData();

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findBookingById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public AirlineBooking findBookingById(int id){
        for (int i =0; i < airlineBookings.size();i++){
            if(airlineBookings.get(i).getBookingId() == id){
                return airlineBookings.get(i);
            }
        }
        return null;
    }

    private void loadData() {

        try {
            String filePath = "C:\\mycode\\java\\incapsularea\\AirlineBooking\\src\\airlineBooking\\data\\airlineBookings.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                AirlineBooking airlineBooking = new AirlineBooking(line);

                this.airlineBookings.add(airlineBooking);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void addBooking(AirlineBooking airlineBooking) {

        this.airlineBookings.add(airlineBooking);

    }

    public boolean hasBookingPassenger(int passengerId) {

        for(int i = 0 ; i < airlineBookings.size(); i++){
            if(airlineBookings.get(i).getPassengerId() == passengerId){
                return false;
            }

        }
        return true;
    }

    public AirlineBooking passengerBooking(int passengerId) {
        for(int i = 0 ; i < airlineBookings.size(); i++){
            if(airlineBookings.get(i).getPassengerId() == passengerId){
                return airlineBookings.get(i);
            }
        }
        return null;
    }

    public boolean deleteBooking(int passengerId) {

        for(int i = 0 ; i < airlineBookings.size(); i++){
            if(airlineBookings.get(i).getPassengerId() == passengerId){
                airlineBookings.remove(i);
                return true;
            }
        }
        return false;
    }

}
