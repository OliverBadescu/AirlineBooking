package passengers.service;

import passengers.model.Passanger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PassangerService {

    private ArrayList<Passanger> passangers;

    public PassangerService() {

        this.passangers = new ArrayList<>();
        this.loadData();

    }

    private void loadData() {

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\AirlineBooking\\src\\passengers\\data\\passangers.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Passanger passanger = new Passanger(line);

                this.passangers.add(passanger);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
