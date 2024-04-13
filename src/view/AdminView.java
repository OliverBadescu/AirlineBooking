package view;

import admin.service.AdminService;
import airlineBooking.service.AirlineBookingService;
import airlineEnquiry.model.AirlineEnquiry;
import airlineEnquiry.service.AirlineEnquiryService;
import bookingEnquiry.service.BookingEnquiryService;
import flights.model.Flight;
import flights.service.FlightService;
import passengers.model.Passanger;
import passengers.service.PassangerService;
import tickets.service.TicketService;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {

    private AdminService adminService;
    private AirlineBookingService airlineBookingService;
    private AirlineEnquiryService airlineEnquiryService;
    private BookingEnquiryService bookingEnquiryService;
    private FlightService flightService;
    private PassangerService passangerService;
    private TicketService ticketService;
    private Scanner scanner;

    public AdminView() {
        this.adminService = new AdminService();
        this.airlineBookingService = new AirlineBookingService();
        this.airlineEnquiryService = new AirlineEnquiryService();
        this.bookingEnquiryService = new BookingEnquiryService();
        this.flightService = new FlightService();
        this.passangerService = new PassangerService();
        this.ticketService = new TicketService();
        this.scanner = new Scanner(System.in);

        this.play();
    }

    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a afisa enquiryruile de la booking-uri");
        System.out.println("Apasati tasta 2 pentru a afisa enquiryruile de la airline-uri");
        System.out.println("Apasati tasta 3 pentru a afisa passageri");
        System.out.println("Apasati tasta 4 pentru a sterge un passager");
        System.out.println("Apasati tasta 5 pentru a aduaga un zbor");
        System.out.println("Apasati tasta 6 pentru a sterge un zbor");
        System.out.println("Apasati tasta 7 pentru a afisa cel mai cumparat zbor");
        System.out.println("Apasati tasta 8 pentru a afisa zborurile");
        System.out.println("Apasati tasta 9 pentru a sorta cerscator dupa vanzari zboruirle");

        System.out.println("\n");
        System.out.println("Apasati tasta 10 pentru a iesi din aplicatie");

    }

    private void play(){

        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    bookingEnquiryService.afisare();
                    break;
                case 2:
                    airlineEnquiryService.afisare();
                    break;
                case 3:
                    passangerService.afisare();
                    break;
                case 4:
                    stergerePassager();
                    break;
                case 5:
                    adaugareZbor();
                    break;
                case 6:
                    stergereZbor();
                    break;
                case 7:
                    celMaiCumparatZbor();
                    break;
                case 8:
                    flightService.afisareFlights();
                    break;
                case 9:
                    sortareDupaBilet();
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }

    }

    private void stergerePassager(){

        System.out.println("Introducet id-ul pasagerului: ");
        int id =Integer.parseInt(scanner.nextLine());

        Passanger passanger = passangerService.findPassengerById(id);

       if(passangerService.stergerePassager(passanger)){
           System.out.println("Pasagerul a fost sters");
       }else{
           System.out.println("Pasagerul nu a fost gasit");
       }

    }

    private void adaugareZbor(){

        System.out.println("Introduceti ruta zborului: ");
        String ruta = scanner.nextLine();
        System.out.println("Introduceti numele: ");
        String nume = scanner.nextLine();
        System.out.println("Introdcueti data zborului: ");
        String data = scanner.nextLine();

        Flight flight= new Flight(flightService.generateId(), 0, nume, ruta, data);

        if(flightService.addFlight(flight)){
            System.out.println("Zborul a fost adaugat");
        }else{
            System.out.println("Exista deja un zbor cu aceasta ruta si aceeasi data");
        }

    }

    private void stergereZbor(){
        System.out.println("Introduceti id-ul zborului care doriti sa il stergeti: ");
        int id =Integer.parseInt(scanner.nextLine());

        Flight flight = flightService.findFlightById(id);

        if(flightService.stergereZbor(flight)){
            System.out.println("Zborul a fost sters");
        }else{
            System.out.println("Zborul nu a fost gasit");
        }
    }

    private void celMaiCumparatZbor(){

        Flight flight = flightService.celMaiCumparatZbor();

        System.out.println(flight.descriere());

    }

    private void sortareDupaBilet(){
        ArrayList<Flight> flights = flightService.getFlights();

        boolean sortat = false;

        do{
            sortat = true;

            for(int i =0; i < flights.size()-1; i++){
                if(flightService.nrTickets(flights.get(i)) > flightService.nrTickets(flights.get(i+1))){
                    Flight temp = flights.get(i);
                    flights.set(i, flights.get(i+1));
                    flights.set(i+1, temp);
                    sortat = false;
                }
            }
        }while(!sortat);
    }

}
