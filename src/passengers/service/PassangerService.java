package passengers.service;

import bookingEnquiry.model.BookingEnquiry;
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

    public void afisare(){
        for (int i = 0; i < this.passangers.size(); i++){
            System.out.println(passangers.get(i).descriere());
        }
    }

    public Passanger login(String username, String password) {
        for(int i = 0; i<this.passangers.size(); i++){
            if(passangers.get(i).getPassengerUsername().equals(username) && passangers.get(i).getPassengerPassword().equals(password)){
                return this.passangers.get(i);
            }
        }
        return null;
    }

    public boolean inregistrare(Passanger passanger) {
        for(int i = 0; i<this.passangers.size(); i++){
            if(this.passangers.get(i).getPassengerUsername().equals(passanger.getPassengerUsername())){
                return false;
            }
        }
        this.passangers.add(passanger);
        return true;
    }

    public int generateId(){

        int id=(int) Math.round(Math.random()*1000+1);

        while (findPassengerById(id)!=null){
            id=(int) Math.round(Math.random()*1000+1);
        }

        return id;

    }

    public Passanger findPassengerById(int id){
        for (int i =0; i < passangers.size();i++){
            if(passangers.get(i).getPassengerId() == id){
                return passangers.get(i);
            }
        }
        return null;
    }

    public boolean stergerePassager(Passanger passanger) {
        for(int i = 0; i<this.passangers.size(); i++){
            if(this.passangers.get(i).getPassengerId() == passanger.getPassengerId()){
                this.passangers.remove(i);
                return true;
            }
        }
        return false;
    }

}
