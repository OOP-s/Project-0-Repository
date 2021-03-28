package ToDoListManager;

public class project extends itemList {
// The project constructor
    protected project(String title, String description) {
        super(title, description);
    }
// A method that creates a new project according to the parameters
    public project newProject(String title, String description) {
       return new project(title,description);
    }
}
