package ToDoListManager;

import java.time.LocalDate;

public abstract class Item {
    // Variables
    protected static String title;
    protected static String description;
    protected static transient Project project;
    protected static transient subProject subProject;
    protected static LocalDate dueDate;
    protected static String priority;
    protected static String[] labels;

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
    public static String[] getLabels() { return labels; }

    public static subProject getSubProject() { return subProject; }
    public static void setSubProject(subProject subP) { subProject = subP; }
    public static Project getProject() { return project; }
    public static void setProject(Project project) { project = project; }
    public static void setTitle(String title) { title = title; }
    public static void setDescription(String description) { description = description; }

    public String toString() {
        return "\n Item [ title: "+title+", description: "+ description+
                "\n"+ "due date: " +dueDate + "priority: " +priority + "labels: "+ labels + " ]";
    }
}