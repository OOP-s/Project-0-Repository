package ToDoListManager;

public class testItem {
    private String title;
    private String description;
    private Project project;
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
    public Project getProject() { return project; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) {
        this.description = description;
    }
    public String toString() {
        return "\n testItem [ title: "+title+", description: "+ description+ " ]";
    }
}
