package ToDoListManager;

public class subProject extends project {

    private project parent;

    protected subProject(String title, String description, project parentProject) {
        super(title, description);
        parent = parentProject;
    }

    public subProject newSubProject(String title, String description, subProject parentProject) {
        return new subProject(title,description,parentProject);
    }

    public project getParentProject() { return parent; }
    public void setParentProject(project project) { parent = project; }

}
