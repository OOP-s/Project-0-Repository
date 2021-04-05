package ToDoListManager;

public class Task extends Item {
    private String priority;
    private String[] labels;
    private String description;
    private transient itemList parentProject;
    private String getTitle;

    Task(String t, String d) {
        super(t, d);
    }

    public Task(String title, String description, String[] labels){
        super(title, description);
        this.labels = labels;
    }
    /*public Task(String description, itemList parentProject){
        this.description = description;
    }
    public Task(String title, String dueDate, String priority){
        this.priority = priority;
    }

    public Task() {
    }
*/
    public String getDescription() {
        return description;
    }
    public String[]  getLabel() {
        return labels;
    }

    public void setPriority(String Priority){
        this.priority = Priority;
    }


}

