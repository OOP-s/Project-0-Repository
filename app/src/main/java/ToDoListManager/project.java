package ToDoListManager;

public class project extends itemList {

    protected project(String title, String description) {
        super(title, description);
    }

    public project newProject(String title, String description) {
       return new project(title,description);
    }

    public void selectProjectForDisplay() {  }

}
