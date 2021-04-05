package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Manager {
    public static ArrayList<User> users = new ArrayList<>();
    public static Admin admin = new Admin();

    //method to register user.
    public static void registerUser(String username, String password, String firstName, String lastName) throws IOException {
        //code to read all users from gson file into the ArrayList.
        User newUser = new User(username, password, firstName, lastName);
        users.add(newUser);
        //code to write all users into a gson file.
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("userInfo/Users");
        writer.write(gson.toJson(users));
        writer.close();
        // Creating the default projects each user has
        Project Upcoming = Project.newProject(newUser,"Upcoming","Upcoming Tasks");
        Project Today = Project.newProject(newUser,"Today","Tasks Due Today");
        Project Overdue = Project.newProject(newUser,"Overdue","Overdue Tasks");
        Project Completed = Project.newProject(newUser,"Completed","Completed Tasks");
        // Writing the default projects to file
        fileRead.writeJSON(Upcoming,newUser,"Upcoming");
        fileRead.writeJSON(Overdue,newUser,"Overdue");
        fileRead.writeJSON(Today,newUser,"Today");
        fileRead.writeJSON(Completed,newUser,"Completed");
    }



    //method for logging in as a user.
    public static int loginUser(String username, String password) {
        //code to read all users from gson file into the ArrayList.
        int amntUsers = users.size();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                //code to login to the users account.
                return 1;
            }
        }
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            //code to login as admin.
            return 2;
        }
        else {
            // code to display invalid login.
            return 0;
        }
    }

    public ArrayList<User> returnUsers() throws IOException {
        Manager manager = fileRead.userFileReader();
        return manager.users;

    }

    //public static void main(String[] args) throws IOException {
      //  Manager manager = new Manager();
       // manager.registerUser("stougarr", "passw0rd", "Garrett", "Stouffer");
       // manager.registerUser("test", "testing", "bill", "Hopkins");
       // System.out.println(manager.users.toString());
 //   }


}
