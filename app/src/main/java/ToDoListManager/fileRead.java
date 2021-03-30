package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileRead {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    public Project projectFileReader(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("ProjectDataFiles/"+filename));
        return gson.fromJson(bufferedReader, Project.class);
    }

    public testItem testItemFileReader(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("ProjectDataFiles/"+filename));
        return gson.fromJson(bufferedReader, testItem.class);
    }

    public static void writeJSON(Object object, String filename) throws IOException {
        FileWriter writer = new FileWriter("ProjectDataFiles/"+filename);
        writer.write(gson.toJson(object));
        writer.close();
    }
    public static void main(String[] args){
        try{
            fileRead tester = new fileRead();
            testItem item = new testItem("testItemTitle","testItemDescription");
            testItem item2 = new testItem("testItemTitle2","testItemDescription2");
            Project testProject = ToDoListManager.Project.newProject("testProjectTitle","testProjectDescription");
            testProject.addItem(item);
            testProject.addItem(item2);
            writeJSON(testProject, testProject.getTitle());

            Project testProject2 = ToDoListManager.Project.newProject("testProjectTitle2","testProjectDescription2");
            testProject2.addItem(item2);
            writeJSON(testProject2,testProject2.getTitle());
            System.out.println(tester.projectFileReader(testProject.getTitle()));
            System.out.println(tester.projectFileReader(testProject2.getTitle()));


        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}
