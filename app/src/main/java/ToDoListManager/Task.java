package ToDoListManager;
import java.io.IOException;
import java.time.LocalDate;

public class Task extends Item {

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

}

