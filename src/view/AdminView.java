package view;

import admin.service.AdminService;
import airlineBooking.service.AirlineBookingService;
import airlineEnquiry.model.AirlineEnquiry;
import airlineEnquiry.service.AirlineEnquiryService;
import bookingEnquiry.service.BookingEnquiryService;
import flights.service.FlightService;
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



    }

    private void play(){

        

    }




}
