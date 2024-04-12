package admin.model;

public class Admin {

    private int id;
    private String username;
    private String password;

    public Admin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Admin(String text){

        String[] tokens = text.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.username = tokens[1];
        this.password = tokens[2];

    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String descriere(){

        String text = "";
        text += "ID: " + this.id + "\n";
        text += "Username: " + this.username + "\n";
        text += "Password: " + this.password + "\n";
        return text;

    }

}
