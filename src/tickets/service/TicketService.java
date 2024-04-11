package tickets.service;

import airlineBooking.model.AirlineBooking;
import tickets.model.Ticket;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketService {

    private ArrayList<Ticket> tickets;

    public TicketService() {
        this.tickets = new ArrayList<>();
        this.loadData();

    }

    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\AirlineBooking\\src\\tickets\\data\\tickets.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Ticket ticket = new Ticket(line);

                this.tickets.add(ticket);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findTicketById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Ticket findTicketById(int id){
        for (int i =0; i < tickets.size();i++){
            if(tickets.get(i).getTicketId() == id){
                return tickets.get(i);
            }
        }
        return null;
    }

    public void afisareTickets(){

        for(int i = 0;i<tickets.size();i++){
            System.out.println(tickets.get(i).desciere());
        }

    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public ArrayList<Ticket> getPassengerTicketList(int passengerId){

        ArrayList<Ticket> passengerTickets = new ArrayList<>();

        for(int i =0; i < tickets.size(); i++){
            if(tickets.get(i).getPassengerId() == passengerId){
                passengerTickets.add(tickets.get(i));
            }
        }
        return passengerTickets;
    }

}
