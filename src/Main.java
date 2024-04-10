import passengers.model.Passanger;
import passengers.service.PassangerService;
import view.PassengerView;

public class Main {
    public static void main(String[] args) {

        PassangerService passangerService = new PassangerService();
        Passanger passanger = new Passanger(5,5,"Luca Rossi",666333111,"luca@example.com","luca_r", "luca123","321 Maple Lane,Anytown USA");

        PassengerView pv = new PassengerView(passanger);
    }
}