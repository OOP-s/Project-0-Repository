package ToDoListManager;


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
        return newP;
    }

    public String toString() {
        return "Project [ Title: "+getTitle()+", Description: "+ getDescription() +"\n"
                +" linkedItemList: " + linkedItemList.toString() + "\n"
                + ", SubProjectTitles: " + subProjectTitles +"]";
    }
}
