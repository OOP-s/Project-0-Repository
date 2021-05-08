package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;


public class Manager {
    public static ArrayList users = new ArrayList<>();
    public static Admin admin = new Admin();

    public Manager (){}

    public static ArrayList getUsers(){return users;}
    public void setUsers(ArrayList<String> userSet){users = userSet;}
    public static Admin getAdmin(){return admin;}

    //method to register user.
    public static void registerUser(String username, String password, String firstName, String lastName, String biography) throws IOException {


        //code to read all users from gson file into the ArrayList.
        //users = returnUsers();
        //code to add additional user
        User newUser = new User(username, password, firstName, lastName, biography);

        if (returnUsers() != null){users = returnUsers();
        } else {users = new ArrayList<>();}
        users.add(newUser.toString());

        //code to write all users into a gson file.
        fileRead.userFileWriter();

        try {
            Path path = Paths.get("DataFiles/Users/" + username + "/");
            Files.createDirectory(path);
            System.out.println("Directory is Created");
        } catch (IOException e) {
            System.err.println("Failed to create a directory!" + e.getMessage());
        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("DataFiles/Users/"+username+"/ProjectNames");
        Type type = new TypeToken<LinkedList<String>>(){}.getType();
        LinkedList<String> list = new LinkedList<>();
        writer.write(gson.toJson(list, type));
        writer.close();

        // Creating the default projects each user has
        Project Upcoming = Project.newProject(newUser, "Upcoming", "Upcoming Tasks");
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
    public static int loginUser(String username, String password) throws IOException {

        ArrayList<String> usersList = returnUsers();
        for (String user: usersList) {
            //retrieving the username and password from each string.
            String savedUsername = user.substring(11, user.indexOf(" Password: "));
            String savedPassword = user.substring(user.indexOf("Password: ") + 10, user.indexOf(" Name:"));
            if (savedUsername.equals(username) && savedPassword.equals(password)) {
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

    public static ArrayList returnUsers() throws IOException {
        return fileRead.userFileReader();
    }

    public static void main(String[] args) throws IOException {

        loginUser("MrMagic","1");

    }

}
