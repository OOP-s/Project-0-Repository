package ToDoListManager;
import java.time.LocalDate;

public class testItem {
    private String title;
    private String description;
    private transient Project project;
    private transient subProject subProject;
    private LocalDate dueDate;
    private String priority;
    private String[] labels;
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
    public LocalDate getDueDate() { return dueDate; }
    public String getPriority() { return priority; }
    public String[] getLabels() { return labels; }
    public subProject getSubProject() { return subProject; }
    public void setSubProject(subProject subP) { subProject = subP; }
    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public String toString() {
        return "\n testItem [ title: "+title+", description: "+ description+
                "\n"+ "due date: " +dueDate + "priority: " +priority + "labels: "+ labels + " ]";
    }
}
