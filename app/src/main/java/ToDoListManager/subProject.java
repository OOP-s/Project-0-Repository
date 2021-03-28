package ToDoListManager;

public class subProject extends project {
// The subproject's parent is a project, this stops sub projects from having subprojects
    private project parent;
// Protected subproject constructor
    protected subProject(String title, String description, project parentProject) {
        super(title, description);
        parent = parentProject;
    }
// Public method that creates and returns a new subproject
    public subProject newSubProject(String title, String description, project parentProject) {
        return new subProject(title,description,parentProject);
    }
// Get-er and Set-er for parent projects
    public project getParentProject() { return parent; }
    public void setParentProject(project project) { parent = project; }

}
