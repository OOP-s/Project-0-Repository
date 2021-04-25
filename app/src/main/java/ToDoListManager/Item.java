package ToDoListManager;
//doesn't our task constructor need a project and/or subproject??
//On the file read for subprojects does "/Subprojects" mean that there is a whole other folder for subprojects? i thought that
// subprojects were folders inside of a project folder.
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
        title = t;
        description =d;
        project = pro;
        dueDate = due;
        priority = pri;
    }
    protected Item(String t, String d, subProject subPro, LocalDate due, String pri) {
        title = t;
        description = d;
        subProject = subPro;
        dueDate = due;
        priority = pri;
    }

    // Get-er's and Set-er's
    public static String getTitle() { return title; }
    public static String getDescription() {
        return description;
    }
    public static LocalDate getDueDate() { return dueDate; }
    public static String getPriority() { return priority; }
    public static List<String> getLabels() { return labels; }

    public void setDueDate(LocalDate time) {
        dueDate = time;
    }

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