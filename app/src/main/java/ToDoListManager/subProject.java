package ToDoListManager;
import java.nio.file.*;

import java.io.IOException;

public class subProject extends Project {
// The subproject's parent is a project, this stops sub projects from having subprojects
    private Project parent;
// Protected subproject constructor
    protected subProject(String title, String description, Project parentProject) {
        super(title, description);
        parent = parentProject;
    }
// Public method that creates and returns a new subproject
    public subProject newSubProject(String title, String description, Project parentProject) throws IOException {
        subProject newS = new subProject(title,description,parentProject);
        fileRead.writeJSONSub(newS, newS.getUser(), newS.getTitle());
        parentProject.addSubProject(newS);
        return newS;
    }
// Get-er and Set-er for parent projects
    public Project getParentProject() { return parent; }
    public void setParentProject(Project project) throws IOException {
        parent = project;
        fileRead.writeJSONSub(this, project.getUser(), this.getTitle());
        Files.deleteIfExists(Paths.get("DataFiles/Users/"+this.getUser().getUsername()+"/SubProjects/" + this.getTitle()));
    }
// This methods changes a subProject to a Project
    public void convertSubProject() throws IOException {
        Project project = newProject(this.getUser(), this.getTitle(), this.getDescription());
        Item itemHolder;
        int length = this.linkedItemList.size();
        for (int i = 0; i < length; i++) {
            itemHolder = this.linkedItemList.get(i);
            this.linkedItemList.remove(i);
            project.linkedItemList.addFirst(itemHolder);
        }
        fileRead.writeJSON(project, project.getUser(), project.getTitle());
        Files.deleteIfExists(Paths.get("DataFiles/Users/"+this.getUser().getUsername()+"/SubProjects/" + this.getTitle()));
    }

    public String toString() {
        return "Subproject [ Title: "+getTitle()+", Description: "+ getDescription() +"\n"
                +" linkedItemList " + linkedItemList.toString() +"\n" +
                " Parent " + parent.getTitle() + "]";
    }

}
