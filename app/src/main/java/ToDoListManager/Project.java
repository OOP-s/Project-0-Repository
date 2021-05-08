package ToDoListManager;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;


public class Project extends itemList {
// The project constructor
    protected Project(String title, String description) {
        super(title, description);
    }

    protected static List<String> subProjectTitles;

    public static List<String> getSubProjectTitles() { return subProjectTitles; }

    public static void addSubProject(subProject subProject) {
        subProjectTitles.add(subProject.getTitle());
    }

// A method that creates a new project according to the parameters
    public static Project newProject(User user, String title, String description) throws IOException {
        Project newP = new Project(title,description);
        newP.setUser(user);
        fileRead.writeJSON(newP,user,title);
        user.addProject(title);
        try {
            Path path = Paths.get("DataFiles/Users/" + title + "/SubProjects/");
            Files.createDirectory(path);
            System.out.println("Directory is Created");
        } catch (IOException e) {
            System.err.println("Failed to create a directory!" + e.getMessage());
        }
        return newP;
    }

    public String toString() {
        return "Project [ Title: "+getTitle()+", Description: "+ getDescription() +"\n"
                +" linkedItemList: " + linkedItemList.toString() + "\n"
                + ", SubProjectTitles: " + subProjectTitles +"]";
    }
}
