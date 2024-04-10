package flights.service;

import flights.model.Flight;
import tickets.model.Ticket;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightService {

    private ArrayList<Flight> flights;

    public FlightService() {

        this.flights = new ArrayList<>();
        this.loadData();

    }

    private void loadData() {

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\AirlineBooking\\src\\flights\\data\\flights.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Flight flight = new Flight(line);

                this.flights.add(flight);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void afisareFlights(){

        for (int i =0; i < this.flights.size(); i++){

            System.out.println(flights.get(i).descriere());
        }

    }

    public Flight findByRoute(String route){
        for(int i =0; i < this.flights.size(); i++){
            if(flights.get(i).getFlightRoute().equals(route)){
                return flights.get(i);
            }
        }
        return null;
    }

}
