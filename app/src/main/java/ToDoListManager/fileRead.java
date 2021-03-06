package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class fileRead {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();
// Reads and returns a project
    public static Project projectFileReader(User user, String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("DataFiles/Users/"+user.getUsername()+"/"+filename));
        return gson.fromJson(bufferedReader, Project.class);
    }
    // Reads and returns a subproject
    public static subProject subProjectFileReader(User user, String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("DataFiles/Users/"+user.getUsername()+"/SubProjects/"+filename));
        return gson.fromJson(bufferedReader, subProject.class);
    }
    // Reads all of the users in the UserInfo folder and then returns a manager instance (which should have the ArrayList that contains all of the users
    public static Manager userFileReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("userInfo/Users"));
        return gson.fromJson(bufferedReader, Manager.class);
    }
    // Write a project to file
    public static void writeJSON(Project project,User user, String filename) throws IOException {
        FileWriter writer = new FileWriter("DataFiles/Users/"+user.getUsername()+"/"+filename);
        writer.write(gson.toJson(project));
        writer.close();
    }
    // Write a subproject to file
    public static void writeJSONSub(subProject subproject,User user, String filename) throws IOException {
        FileWriter writer = new FileWriter("DataFiles/Users/"+user.getUsername()+"/SubProjects/"+filename);
        writer.write(gson.toJson(subproject));
        writer.close();
    }



    static User writeUsers(String username, String password, String firstName, String lastName, String biography) throws IOException {
        Manager manager = new Manager();
        //code to read all users from gson file into the ArrayList.
        manager.setUsers(manager.returnUsers());
        User newUser = new User(username, password, firstName, lastName, biography);
        manager.users.add(newUser);
        //code to write all users into a gson file.

        FileWriter writer = new FileWriter("userInfo/Users");
        writer.write(gson.toJson(manager));
        writer.close();
        return newUser;
    }
}
