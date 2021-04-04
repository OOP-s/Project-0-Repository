package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Manager {
    public User[] users;
    public Admin admin;

    //add user to the user array
    private User[] addUser(User[] currentUsers, User newUser){
        int currentSize = currentUsers.length;
        User[] newUsers = new User[currentSize+1];
        // add all other users to new array
        for (int i=0; i<currentSize + 1; i++ ){
            newUsers[i] = currentUsers[i];
        }
        // add new element
        newUsers[currentSize + 1] = newUser;
        return newUsers;
    }
    //function to register new user
    public void registerUser(String username, String password, String firstName, String lastName) throws IOException {
        User newUser =  new User(username, password, firstName, lastName);
        users = addUser(users, newUser);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("userInfo/users");
        writer.write(gson.toJson(users));
        writer.close();

    }

    //code that runs win the user press login
    public void userLogin(String username, String password){
        int numUsers = users.length;
        for (int i=0; i< numUsers; i++) {
            User potentialUser = users[i];
            if(potentialUser.checkLogin(username,password)){
                //code to Login and go to users account
            }
        }
        if (admin.checkLogin(username, password)){
            //code to Login as admin
        }
    }
    public static void main(String[] args) throws IOException {
        Manager manager = new Manager();
        manager.registerUser("stougarr", "password", "Garrett", "Stouffer");
    }
}
