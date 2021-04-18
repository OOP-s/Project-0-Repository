package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Manager {
    public static ArrayList<User> users = new ArrayList<User>();
    public static Admin admin = new Admin();


    public Manager (){}
    public static ArrayList<User> getUsers(){return users;}
    public void setUsers(ArrayList<User> userSet){users = userSet;}
    public static Admin getAdmin(){return admin;}

    //method to register user.
    public static void registerUser(String username, String password, String firstName, String lastName, String biography) throws IOException {
        Manager manager = new Manager();
        //code to read all users from gson file into the ArrayList.
        manager.setUsers(returnUsers());
        User newUser = new User(username, password, firstName, lastName, biography);
        getUsers().add(newUser);
        //code to write all users into a gson file.

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("userInfo/Users");
        writer.write(gson.toJson(manager));
        writer.close();

        try {
            Path path = Paths.get("DataFiles/Users/" + username + "/");
            Files.createDirectory(path);
            System.out.println("Directory is Created");
        } catch (IOException e) {
            System.err.println("Failed to create a directory!" + e.getMessage());
        }
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

    public static ArrayList<User> returnUsers() throws IOException {
        Manager manager = fileRead.userFileReader();
        return  manager.users;
    }



}
