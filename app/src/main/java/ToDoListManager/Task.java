package ToDoListManager;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Task extends Item {


    private Boolean isComplete = false;

    protected Task(String t, String d, Project pro, LocalDate due, String pri) {
        super(t,d,pro,due,pri);
    }

    public Task newTask(String t, String d, Project pro, LocalDate due, String pri) throws IOException {
        Task task = new Task(t,d,pro,due,pri);
        task.getProject().addItem(task,Task.getProject());
        return task;
    }


    public String toString() {
        return "\n Task [ title: "+title+", description: "+ description+
                "\n"+ "due date: " +dueDate + "priority: " +priority + "labels: "+ labels + " ]";
    }

    //getter methods
    public Boolean getIsComplete() { return isComplete; }


    //setter methods
    public void setIsComplete(Boolean value) { isComplete = value; }


    public void markComplete() {
        setIsComplete(true);
        //move task to complete list
    }
    public Task duplicateTask(Task task){
        Task duplicateTask = task;
        return duplicateTask;
    }
    //method for moving tasks from one list to another.
    public void moveTask(Project newProject) {
        setProject(newProject);
    }
    public void moveTask(subProject newSubProject) {
        Project parentProject = newSubProject.getParentProject();
        setProject(parentProject);
        setSubProject(newSubProject);
    }


}

