package ToDoListManager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public abstract class Item {
    // Variables
    protected static String title;
    protected static String description;
    protected static transient Project project;
    protected static transient subProject subProject;
    protected static LocalDate dueDate;
    protected static String priority;
    protected static List<String> labels;

    protected Item(String t, String d, Project pro, LocalDate due, String pri) {
        t = title;
        d = description;
        pro = project;
        due = dueDate;
        pri = priority;
    }

    // Get-er's and Set-er's
    public static String getTitle() { return title; }
    public static String getDescription() {
        return description;
    }
    public static LocalDate getDueDate() { return dueDate; }
    public static String getPriority() { return priority; }
    public static List<String> getLabels() { return labels; }


    public static Project getProject() { return project; }
    public static subProject getSubProject() { return subProject; }
    public static void setSubProject(subProject subP) { subProject = subP;}
    public static void setProject(Project project) { project = project; }
    public static void setTitle(String title) { title = title; }
    public static void setDescription(String description) { description = description; }



    public String toString() {
        return "\n Item [ title: "+title+", description: "+ description+
                "\n"+ "due date: " +dueDate + "priority: " +priority + "labels: "+ labels + " ]";
    }
    public static void addLabel(String label, Task task) throws IOException {
        labels.add(label);
        Project.removeItem(task);
        Project.addItem(task, task.getProject());
        fileRead.writeJSON(task.getProject(), task.getProject().getUser(),task.getTitle());
    }
    public static void removeLabel(String label, Task task) throws IOException {
        labels.remove(label);
        Project.removeItem(task);
        Project.addItem(task, task.getProject());
        fileRead.writeJSON(task.getProject(), task.getProject().getUser(),task.getTitle());
    }
}