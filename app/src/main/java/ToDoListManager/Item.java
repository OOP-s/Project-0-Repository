package ToDoListManager;

public class Item {
    private String title;
    private String description;
    private transient Project project;
    Item(String t, String d) {
        title = t;
        description = d;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) {
        this.description = description;
    }
    public String toString() {
        return "\n testItem [ title: "+title+", description: "+ description+ " ]";
    }
}