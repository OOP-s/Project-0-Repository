package ToDoListManager;

public class Task extends Item {
    private String dueDate;
    private String priority;
    private String[] labels;
    private transient itemList parentProject;
    private boolean isOverdue;
    private boolean isCompleted;

    public Task(String title, String description, String[] labels){
        super(title, description);
        this.labels = labels;
    }
    public Task(, description: string, parentProject: ItemList){
        this.title = title;
        this.descreption = description;
        this.parentProject = initial project;
    }
    public Task(title: string, Due Date: string, Priority: string){
        this.title = title;
        this.dueDate = due date;
        this.priority = priority;
    }
    public Task(
            public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String array getLabel() {
        return label;
    }
    public ItemList getparentProject() {
        return parentProject;
    }

    public void setdueDate(String dueDate){
        this.dueDate = due date;
    }
    public void setPriority(String Priority){
        this.Priority = Priority;
    }
    public void setparentProject(itemlist){
        this.setparentProject = parentProject;
    }
    public void setisOverdue(Boolean){
        this.isOverdue = Overdue;
    }
    public void setisCompleted(Boolean){
        this.setisCompleted = Complete;
    }
}

