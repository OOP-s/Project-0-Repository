package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();
// Reads and returns a project
    public static Project projectFileReader(User user, String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("DataFiles/Users/"+user.getUsername()+"/"+filename));
        return gson.fromJson(bufferedReader, Project.class);
    }
    // Reads and returns a subproject
    public static Project subProjectFileReader(User user, String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("DataFiles/Users/"+user.getUsername()+"/SubProjects/"+filename));
        return gson.fromJson(bufferedReader, subProject.class);
    }
    // Reads all of the users in the UserInfo folder and then returns a manager instance (which should have the ArrayList that contains all of the users
    public Manager userFileReader() throws IOException {
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
    public static void writeJSON(subProject project,User user, String filename) throws IOException {
        FileWriter writer = new FileWriter("DataFiles/Users/"+user.getUsername()+"/SubProjects/"+filename);
        writer.write(gson.toJson(project));
        writer.close();
    }

}
