package admin.service;

import admin.model.Admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminService {

    private ArrayList<Admin> admins;

    public AdminService() {
        this.admins = new ArrayList<>();

        this.loadData();
    }

    private void loadData(){

        try{
            String filePath="C:\\mycode\\java\\incapsularea\\AirlineBooking\\src\\admin\\data\\admins.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Admin admin = new Admin(line);

                this.admins.add(admin);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
