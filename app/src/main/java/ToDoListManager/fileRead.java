package ToDoListManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileRead {

    static class testItem {
    private String title;
    private String description;
    testItem(String t, String d) {
    title = t;
    description = d;
    }
    public String getTitle() {
        return title;
        }
    public String getDescription() {
            return description;
        }
    public void setTitle(String title) {
            this.title = title;
        }
    public void setDescription(String description) {
            this.description = description;
        }
    public String toString() {
        return "testItem [ title: "+title+", description: "+ description+ " ]";
    }
    }



    private testItem itemFileReader() throws IOException {
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    BufferedReader bufferedReader = new BufferedReader(
            new FileReader("data.json"));
    testItem testitem = gson.fromJson(bufferedReader, testItem.class);
    return testitem;
    }


    private void writeJSON(testItem testItem) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("data.json");
        writer.write(gson.toJson(testItem));
        writer.close();
    }
    public static void main(String[] args){
        try{
            fileRead tester = new fileRead();
            testItem item = new testItem("testtitle","testdescription");
            tester.writeJSON(item);
            testItem item1 = tester.itemFileReader();
            System.out.println(item1);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}
