package tickets.service;

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

}
