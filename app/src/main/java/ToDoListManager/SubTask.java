package ToDoListManager;

import java.io.IOException;
import java.time.LocalDate;

public class SubTask extends Task {

    private static Task parentTask;
    protected SubTask(String t, String d, Project pro, LocalDate due, String pri, Task Parent) {
        super(t,d,pro,due,pri);
        parentTask = Parent;
    }

    public SubTask newSubTask(String t, String d, Project pro, LocalDate due, String pri, Task Parent) throws IOException {
        SubTask subtask = new SubTask(t,d,pro,due,pri,Parent);
        subtask.getProject().addItem(subtask,Task.getProject());
        return subtask;
    }


    public Task getParentTask() {
        return parentTask;
    }
    public void setParentTask(Task task) { parentTask = task; }

    public String toString() {
        return "subTask [ Title: "+getTitle()+", Description: "+ getDescription() +"\n" +
                " Parent " + parentTask.getTitle() + "]";
    }

}
