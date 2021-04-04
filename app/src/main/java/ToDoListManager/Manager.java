package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {
    public ArrayList<User> users = new ArrayList<>();
    public Admin admin = new Admin();

    //method to register user.
    public void registerUser(String username, String password, String firstName, String lastName) {
        //code to read all users from gson file into the ArrayList.
        User newUser = new User(username, password, firstName, lastName);
        users.add(newUser);
        //code to write all users into a new gson file.
    }
    //method for logging in as a user.
    public void loginUser(String username, String password) {
        //code to read all users from gson file into the ArrayList.
        int amntUsers = users.size();
        for (int i =0; i < amntUsers; i++) {
            if(users.get(i).getUsername() == username && users.get(i).getPassword() == password){
                //code to login to the users account.
            }
        }
        if (admin.getUsername() == username && admin.getPassword() == password) {
            //code to login as admin.
        }
        else {
            // code to display invalid login.
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.registerUser("stougarr", "passw0rd", "Garrett", "Stouffer");
        manager.registerUser("test", "testing", "bill", "Hopkins");
        System.out.println(manager.users.toString());
    }


}
