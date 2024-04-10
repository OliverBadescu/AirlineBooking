package view;


import airlineBooking.model.AirlineBooking;
import airlineBooking.service.AirlineBookingService;
import airlineEnquiry.service.AirlineEnquiryService;
import bookingEnquiry.service.BookingEnquiryService;
import flights.model.Flight;
import flights.service.FlightService;
import passengers.model.Passanger;
import passengers.service.PassangerService;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengerView {

    private FlightService flightService;
    private PassangerService passangerService;
    private BookingEnquiryService bookingEnquiryService;
    private AirlineEnquiryService airlineEnquiryService;
    private AirlineBookingService airlineBookingService;
    private Passanger passenger;
    private Scanner scanner;

    public PassengerView(Passanger passenger) {

        this.flightService = new FlightService();
        this.passangerService = new PassangerService();
        this.bookingEnquiryService = new BookingEnquiryService();
        this.airlineEnquiryService = new AirlineEnquiryService();
        this.airlineBookingService = new AirlineBookingService();
        this.passenger = passenger;
        this.scanner = new Scanner(System.in);

        this.play();

    }


    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a afisa lista de zboruri");
        System.out.println("Apasati tasta 2 pentru a face o rezervare");
        System.out.println("Apasati tasta 3 pentru a anula o rezervare");
        System.out.println("Apasati tasta 4 pentru a cumpara un bilet");
        System.out.println("Apasati tasta 5 pentru a afisa rezervarea dvs.");
        System.out.println("Apasati tasta 6 pentru a afisa biletele dvs.");
        System.out.println("Apasati tasta 7 pentru a face un enquiry la o revervare");
        System.out.println("Apasati tasta 8 pentru a face un enquiry la un zbor");
        System.out.println("Apasati tasta 9 pentru a cauta un zbor");

        System.out.println("\n");

        System.out.println("Apasati tasta 11 pentru a va deloga");


    }

    private void play(){

        boolean running = true;

        while(running ){
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {

                case 1:
                    flightService.afisareFlights();
                    break;
                case 2:
                    addBooking();
                    break;
                case 3:
                    deleteBooking();
                    break;
                case 5:
                    afisareRezervare();
                    break;

                case 11:
                    running = false;
                    break;
                default:
                    System.out.println("Tasta incorecta");

            }
        }
    }

    private void addBooking(){

        System.out.println("Introduceti ruta zborului la care doriti sa faceti rezervare(Ruta-Ruta): ");
        String route = scanner.nextLine();

        Flight flight = flightService.findByRoute(route);

        if(airlineBookingService.hasBookingPassenger(this.passenger.getPassengerId())) {
            if (flight != null) {
                System.out.println("Ce tip de zbor doriti? (ex. Buisness, First Class, Economy)");
                String type = scanner.nextLine();
                String descriere = "Rezervarul pentru zborul: " + '\n' + flight.descriere();
                AirlineBooking booking = new AirlineBooking(airlineBookingService.generateId(), this.passenger.getPassengerId(), type, flight.getFlightDate(), descriere);
                airlineBookingService.addBooking(booking);
                System.out.println("Rezervarea a fost adaugata!");
            } else {
                System.out.println("Zborul nu exista");
            }
        }else{
            System.out.println("Aveti deja o rezervare");
        }

    }

    private void deleteBooking(){

        System.out.println("Introduceti ruta zborului la care doriti sa faceti stergeti rezervarea(Ruta-Ruta): ");
        String route = scanner.nextLine();

        Flight flight = flightService.findByRoute(route);
        if(!airlineBookingService.hasBookingPassenger(this.passenger.getPassengerId())) {
            if (flight != null) {
                if(airlineBookingService.deleteBooking(this.passenger.getPassengerId())) {
                    System.out.println("Rezervarea a fost stearsa");
                }else{
                    System.out.println("Nu aveti rezervare la acest zbor");
                }
            }else{
                System.out.println("Acest zbor nu exista");
            }
        }else{
            System.out.println("Nu aveti nici-o rezervare");
        }

    }

    private void afisareRezervare(){

        AirlineBooking booking = airlineBookingService.passengerBooking(this.passenger.getPassengerId());

        if(booking!=  null) {
            System.out.println(booking.descriere());
        }else{
            System.out.println("Nu aveti nici-o rezervare");
        }

    }




}


