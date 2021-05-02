package ToDoListManager;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task extends Item {



    protected Task(String t, String d, Project pro, LocalDate due, String pri) {
        super(t,d,pro,due,pri);
    }
    protected Task(String t, String d, subProject subPro, LocalDate due, String pri) {
        super(t,d,subPro,due,pri);
        project = subPro.getParentProject();
    }
    public Task newTask(String t, String d, Project pro, LocalDate due, String pri) throws IOException {
        Task task = new Task(t,d,pro,due,pri);
        task.getProject().addItem(task, pro);
        return task;
    }
    public Task newTask(String t, String d, subProject subPro, LocalDate due, String pri) throws IOException {
        Task task = new Task(t, d, subPro, due, pri);
        task.getProject().addItem(task, subPro);
        return task;
    }


    public String toString() {
        return "\n Task [ title: "+title+", description: "+ description+
                "\n"+ "due date: " +dueDate + "priority: " +priority + "labels: "+ labels + " ]";
    }


    public void markComplete(Task task) throws IOException {
        //unwrites the task from the project file
        itemList projectFile =  fileRead.projectFileReader(task.getProject().getUser() , task.getProject().getTitle());
        projectFile.removeItem(task);
        //reads than rewrites the users completed list
        Project completedList = fileRead.projectFileReader(task.getProject().getUser(), "Completed");
        completedList.linkedItemList.add(task);
        fileRead.writeJSON( completedList, completedList.getUser(), "Completed");
    }

    public void duplicateTask(Task task) throws IOException {
        Task duplicateTask = task;
        if (task.getSubProject()!= null){
           itemList.addItem(duplicateTask, task.getSubProject());
        }
        //else if task is only in a project
        if (task.getProject() != null && task.getSubProject() == null) {
            itemList.addItem(duplicateTask, task.getProject());
        }
    }

    //method for moving tasks from one list to another.
    public void moveTask(Task task, Project newProject) throws IOException {
        task.getProject().removeItem(task);
        task.getSubProject().removeItem(task);
        itemList.addItem(task, newProject);
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }

}

