package ToDoListManager;

import java.io.IOException;

public class Project extends itemList {
// The project constructor
    protected Project(String title, String description) {
        super(title, description);
    }

// A method that creates a new project according to the parameters
    public static Project newProject(User user, String title, String description) throws IOException {
        Project newP = new Project(title,description);
        newP.setUser(user);
        fileRead.writeJSON(newP,user,title);
        return newP;
    }

    public String toString() {
        return "Project [ Title: "+getTitle()+", Description: "+ getDescription() +"\n"
                +" linkedItemList " + linkedItemList.toString() + "]";
    }
}
