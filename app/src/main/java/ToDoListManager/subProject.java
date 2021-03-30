package ToDoListManager;

public class subProject extends Project {
// The subproject's parent is a project, this stops sub projects from having subprojects
    private Project parent;
// Protected subproject constructor
    protected subProject(String title, String description, Project parentProject) {
        super(title, description);
        parent = parentProject;
    }
// Public method that creates and returns a new subproject
    public subProject newSubProject(String title, String description, Project parentProject) {
        return new subProject(title,description,parentProject);
    }
// Get-er and Set-er for parent projects
    public Project getParentProject() { return parent; }
    public void setParentProject(Project project) { parent = project; }

    public String toString() {
        return "Subproject [ Title: "+getTitle()+", Description: "+ getDescription() +"\n"
                +" linkedItemList " + linkedItemList.toString() +"\n" +
                " Parent " + parent.getTitle() + "]";
    }

}
