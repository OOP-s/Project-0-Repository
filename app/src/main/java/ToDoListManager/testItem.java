package ToDoListManager;

public class testItem {
    private String title;
    private String description;
    private transient Project project;
    private String dueDate;
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
    public String getDueDate() { return dueDate; }
    public String getPriority() { return priority; }
    public String[] getLabels() { return labels; }
    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public String toString() {
        return "\n testItem [ title: "+title+", description: "+ description+ " ]";
    }
}
