package flights.service;

import flights.model.Flight;
import passengers.model.Passanger;
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

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findFlightById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Flight findFlightById(int id){
        for (int i =0; i < flights.size();i++){
            if(flights.get(i).getFlightId() == id){
                return flights.get(i);
            }
        }
        return null;
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

    public boolean addFlight(Flight flight){
        for (int i =0; i < this.flights.size(); i++){
            if(this.flights.get(i).getFlightRoute().equals(flight.getFlightRoute()) && this.flights.get(i).getFlightDate().equals(flight.getFlightDate())){
                return false;
            }
        }
        this.flights.add(flight);
        return true;
    }

    public boolean stergereZbor(Flight flight){
        for (int i =0; i < this.flights.size(); i++){
            if(this.flights.get(i).getFlightId() == flight.getFlightId()){
                this.flights.remove(i);
                return true;
            }
        }
        return false;
    }

    public Flight celMaiCumparatZbor(){

        int imax =0;

        for (int i =0; i < this.flights.size()-1; i++){

            if(this.flights.get(i).getFlightTickets() > this.flights.get(i+1).getFlightTickets()){
                imax=i;
            }
        }
        return this.flights.get(imax);
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public int nrTickets(Flight flight){
        int ct =0;
        for (int i =0; i < this.flights.size(); i++){
            if(this.flights.get(i).getFlightTickets() == flight.getFlightTickets()){
                ct++;
            }
        }
        return ct;
    }
}
