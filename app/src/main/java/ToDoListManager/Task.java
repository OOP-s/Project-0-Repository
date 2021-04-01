package ToDoListManager;

public class Task extends Manager {
    private string dueDate;
    private string priority;
    private string array labels;
    private ItemList parentProject;
    provate boolean isOverdue;
    private boolen isCompleted;

    public Task(title: string, description: string, labels: string array){
        this.title = title;
        this.description = description;
        this.labels = labels;
    }
    public Task(title: string, description: string, parentProject: ItemList){
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

