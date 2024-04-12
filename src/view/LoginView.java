package view;
import passengers.model.Passanger;
import passengers.service.PassangerService;

import java.util.Scanner;

public class LoginView {

    private PassangerService passangerService;
    private Scanner scanner;

    public LoginView(){
        this.passangerService = new PassangerService();
        this.scanner = new Scanner(System.in);

        this.play();
    }

    private void meniu(){

        System.out.println("Apasati tasta 1 pentru a va loga");
        System.out.println("Apasati tasta 2 pentru a va inregistra");
        System.out.println("Apasati tasta 3 pentru a iesi din aplicatie");
        System.out.println(" \n");
        System.out.println("Apasati tasta 4 pentru a va loga ca admin");

    }

    private void play(){

        boolean running = true;

        while (running) {
            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    logarePassenger();
                    break;
                case 2:
                    inregistrarePassenger();
                    break;
                case 3:
                    running = false;
                    break;
                case 4:
                    adminLogin();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }

    }

    private void logarePassenger(){

        System.out.println("Introduceti username-ul si parola");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();

        Passanger passanger = passangerService.login(username, parola);

        if(passanger != null){
            PassengerView pv = new PassengerView(passanger);
        }else{
            System.out.println("Date incorecte");
        }

    }

    private void inregistrarePassenger(){

        System.out.println("Introduceti datele urmatoare:");
        System.out.println("First name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Telefon: ");
        int tel = Integer.parseInt(scanner.nextLine());
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("Adresa: ");
        String adresa = scanner.nextLine();

        int id = passangerService.generateId();
        Passanger passanger = new Passanger(id, firstName + " " + lastName, tel, email, username, password, adresa);

        if(passangerService.inregistrare(passanger)){
            System.out.println("V-ati inregirstrat cu succes, lovati-va pentru a continua");
        }else{
            System.out.println("Username-ul este deja folosit");
        }


    }

    private void adminLogin(){

        System.out.println("Introduceti username-ul si parola");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Parola: ");
        String parola = scanner.nextLine();

    }

}
