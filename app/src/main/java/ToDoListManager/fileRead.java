package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;


public class fileRead {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    // Reads and returns a project
    public static Project projectFileReader(User user, String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("DataFiles/Users/"+user.getUsername()+"/"+filename));
        return gson.fromJson(bufferedReader, Project.class);
    }
    public static Project projectFileReader(String username, String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("DataFiles/Users/"+username+"/"+filename));
        return gson.fromJson(bufferedReader, Project.class);
    }
    // Reads and returns a subproject
    public static subProject subProjectFileReader(User user, String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("DataFiles/Users/"+user.getUsername()+"/SubProjects/"+filename));
        return gson.fromJson(bufferedReader, subProject.class);
    }
    // Reads all of the users in the UserInfo folder and then returns an ArrayList containing the toString version of every user.
    public static ArrayList userFileReader() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("userInfo/Users"));
        return gson.fromJson(bufferedReader, ArrayList.class);
    }

    public static LinkedList projectListReader(User user) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("DataFiles/Users/"+user.getUsername()+"/ProjectNames"));
        return gson.fromJson(bufferedReader, LinkedList.class);
    }
    public static LinkedList projectListReader(String username) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("DataFiles/Users/"+username+"/ProjectNames"));
        return gson.fromJson(bufferedReader, LinkedList.class);
    }
    public static void projectListWriter(User user) throws IOException {
        FileWriter writer = new FileWriter("DataFiles/Users/"+user.getUsername()+"/ProjectNames");
        Type type = new TypeToken<LinkedList>(){}.getType();
        LinkedList list = user.getProjectList();
        writer.write(gson.toJson(list, type));
        writer.close();
    }

    public static void userFileWriter() throws IOException {
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("userInfo/Users");
        writer.write(gson.toJson(Manager.returnUsers(), type));
        writer.close();
    }

    // Write a project to file
    public static void writeJSON(Project project,User user, String filename) throws IOException {
        FileWriter writer = new FileWriter("DataFiles/Users/"+user.getUsername()+"/"+filename);
        Type type = new TypeToken<Project>(){}.getType();
        writer.write(gson.toJson(project, type));
        writer.close();
    }
    // Write a subproject to file
    public static void writeJSONSub(subProject subproject,User user, String filename) throws IOException {
        FileWriter writer = new FileWriter("DataFiles/Users/"+user.getUsername()+"/SubProjects/"+filename);
        writer.write(gson.toJson(subproject));
        writer.close();
    }


}
