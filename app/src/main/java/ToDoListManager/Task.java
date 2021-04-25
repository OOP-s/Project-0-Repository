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
    }
    public Task newTask(String t, String d, Project pro, LocalDate due, String pri) throws IOException {
        Task task = new Task(t,d,pro,due,pri);
        task.getProject().addItem(task,Task.getProject());
        return task;
    }
    public Task newTask(String t, String d, subProject subPro, LocalDate due, String pri) throws IOException {
        Task task = new Task(t, d, subPro, due, pri);
        task.getProject().addItem(task, Task.getProject());
        return task;
    }


    public String toString() {
        return "\n Task [ title: "+title+", description: "+ description+
                "\n"+ "due date: " +dueDate + "priority: " +priority + "labels: "+ labels + " ]";
    }




    public void markComplete(Task task) throws IOException {
        //reads than rewrites the users completed list
        Project completedList = fileRead.projectFileReader(task.project.getUser(), "Completed");
        completedList.linkedItemList.add(task);
        fileRead.writeJSON( completedList, completedList.getUser(), "Completed");
        //move task to complete list
    }

    public void duplicateTask(Task task)throws IOException {
        Task duplicateTask = task;
        //if (task is in subproject) {execute for subproject }
        //else if task is only in a project
        Project project = fileRead.projectFileReader(task.project.getUser(), task.project.getTitle());
        project.linkedItemList.add(task);
    }

    //method for moving tasks from one list to another.
    public void moveTask(Task task, Project newProject) throws IOException {
        //if task is not part of a subproject
        //read tasks project
        Project project = fileRead.projectFileReader(task.project.getUser(), task.project.getTitle());
        //delete task from project and rewrite doc
        project.linkedItemList.remove(task);
        fileRead.writeJSON(project, project.getUser(), project.getTitle());
        //set task newProject and write to new project
        task.setProject(newProject);
        fileRead.writeJSON(task.project, task.project.getUser(), task.project.getTitle());
    }


    public static void main(String[] args) {

    }
}

