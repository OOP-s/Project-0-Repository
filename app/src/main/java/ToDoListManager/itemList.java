package ToDoListManager;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.nio.file.*;
import java.time.LocalDate;
import java.lang.*;


public abstract class itemList {
// The title and description of the project
    private String title;
    private String description;
    private static User user;

// This linked list is going to be the actual data structure that holds the items
    protected static LinkedList<Item> linkedItemList = new LinkedList<Item>();

// Abstract constructor
    protected itemList(String t, String d) {
        title = t;
        description = d;
    }

// Get-er and Set-er methods for title and description
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public User getUser() { return user; }
    public void setUser(User newUser) { user = newUser; }
    public void setTitle(String newTitle) { title = newTitle; }
    public void setDescription(String newDescription) { description = newDescription; }

// This add item method adds the inputted item into the linked list at the end
    public static void addItem(Item item, Project project) throws IOException {
        // Creates a temporary project and reads the projects file to it
        Project newFile = fileRead.projectFileReader(item.getProject().getUser(), item.getProject().getTitle());
        // Adds the new item to the temp project
        newFile.linkedItemList.add(item);
        // Changes the current project to the temp one
        project = newFile;
        item.setProject(project);
        // Writes the project the item is in to file
        fileRead.writeJSON(item.getProject(), item.getProject().getUser(),item.getProject().getTitle());
        // Checks and then writes the item to a default project
        if (item.getDueDate().compareTo(LocalDate.now()) > 0 ) {
            Project Overdue = fileRead.projectFileReader(item.getProject().getUser(), "Overdue");
            Overdue.linkedItemList.add(item);
            fileRead.writeJSON(Overdue, item.getProject().getUser(),"Overdue");
        }
        if (item.getDueDate().compareTo(LocalDate.now()) < 0 ) {
            Project Upcoming = fileRead.projectFileReader(item.getProject().getUser(), "Upcoming");
            Upcoming.linkedItemList.add(item);
            fileRead.writeJSON(Upcoming, item.getProject().getUser(),"Upcoming");
        }
        if (item.getDueDate().equals(LocalDate.now())) {
            Project Today = fileRead.projectFileReader(item.getProject().getUser(), "Today");
            Today.linkedItemList.add(item);
            fileRead.writeJSON(Today, item.getProject().getUser(),"Today");
        }
    }
    public void addItem(Item item, subProject subproject) throws IOException {
        // All comments for the first addItem method work here except its for subProjects
        subProject newFile = (subProject) fileRead.subProjectFileReader(item.getSubProject().getUser(), item.getSubProject().getTitle());
        newFile.linkedItemList.add(item);
        subproject = newFile;
        item.setProject(subproject);
        fileRead.writeJSON(item.getProject(), item.getProject().getUser(),item.getProject().getTitle());
        if (item.getDueDate().compareTo(LocalDate.now()) > 0 ) {
            Project Overdue = fileRead.projectFileReader(item.getProject().getUser(), "Overdue");
            Overdue.linkedItemList.add(item);
            fileRead.writeJSON(Overdue, item.getProject().getUser(),"Overdue");
        }
        if (item.getDueDate().compareTo(LocalDate.now()) < 0 ) {
            Project Upcoming = fileRead.projectFileReader(item.getProject().getUser(), "Upcoming");
            Upcoming.linkedItemList.add(item);
            fileRead.writeJSON(Upcoming, item.getProject().getUser(),"Upcoming");
        }
        if (item.getDueDate().equals(LocalDate.now())) {
            Project Today = fileRead.projectFileReader(item.getProject().getUser(), "Today");
            Today.linkedItemList.add(item);
            fileRead.writeJSON(Today, item.getProject().getUser(),"Today");
        }
    }

// Remove item searches for the first instance of the inputted item and removes it
    public static void removeItem(Item item) throws IOException {
        linkedItemList.remove(item);
        fileRead.writeJSON(item.getProject(), item.getProject().getUser(),item.getProject().getTitle());
        // This checks to see if the item was in any of the default lists and removes it
        Project Overdue = fileRead.projectFileReader(item.getProject().getUser(), "Overdue");
        if (Overdue.linkedItemList.contains(item)) {
            Overdue.linkedItemList.remove(item);
            fileRead.writeJSON(Overdue, item.getProject().getUser(), "Overdue");
        }
        Project Today = fileRead.projectFileReader(item.getProject().getUser(), "Today");
        if (Today.linkedItemList.contains(item)) {
            Today.linkedItemList.remove(item);
            fileRead.writeJSON(Today, item.getProject().getUser(), "Today");
        }
        Project Upcoming = fileRead.projectFileReader(item.getProject().getUser(), "Upcoming");
        if (Upcoming.linkedItemList.contains(item)) {
            Upcoming.linkedItemList.remove(item);
            fileRead.writeJSON(Upcoming, item.getProject().getUser(), "Upcoming");
        }
    }

// The sort methods iterate through the list, then find matches and move them to the front of the list
    public void sortListByDueDate(LocalDate date) {
        int length = linkedItemList.size();
        Item itemHolder;
        for (int i = 0; i < length; i++)  {
            if (linkedItemList.get(i).getDueDate() == date) {
                itemHolder = linkedItemList.get(i);
                linkedItemList.remove(i);
                linkedItemList.addFirst(itemHolder);
            }
        }
    }
    public void sortListByPriority(String priority) {
        int length = linkedItemList.size();
        Item itemHolder;
        for (int i = 0; i < length; i++)  {
            if (linkedItemList.get(i).getPriority().equalsIgnoreCase(priority)) {
                itemHolder = linkedItemList.get(i);
                linkedItemList.remove(i);
                linkedItemList.addFirst(itemHolder);
            }
        }
    }
    public void sortListByLabels(String label) {
        int length = linkedItemList.size();
        Item itemHolder;
        for (int i = 0; i < length; i++) {
            List<String> labelHolder = linkedItemList.get(i).getLabels();
            if (labelHolder.contains(label)) {
                itemHolder = linkedItemList.get(i);
                linkedItemList.remove(i);
                linkedItemList.addFirst(itemHolder);
            }
        }
    }
    // This method finds all of the completed tasks for a provided project and moves them pack while removing them from the completed list
    public void showCompletedTasks(Project project) throws IOException {
        Project Completed = fileRead.projectFileReader(project.getUser(),"Completed");
        int length = Completed.linkedItemList.size();
        for (int i =0; i < length; i++ ) {
            if ( Completed.linkedItemList.get(i).getProject() == project ) {
                Item item = Completed.linkedItemList.get(i);
                addItem(item,project);
                Completed.linkedItemList.remove(i);
                fileRead.writeJSON(Completed, project.getUser(), "Completed");
            }
        }

    }
    // This remove method checks to make sure you aren't attempting to delete a default list and then deletes the list
    public void removeProject() throws IOException {
        if (this.getTitle().equalsIgnoreCase("Today")) {
            if (this.getTitle().equalsIgnoreCase("Upcoming")) {
                if (this.getTitle().equalsIgnoreCase("Overdue")) {
                    if (this.getTitle().equalsIgnoreCase("Completed") ) {
                        Files.deleteIfExists(Paths.get("DataFiles/Users/" + this.getUser().getUsername() + "/" + this.getTitle()));
                    }
                }
            }
        }
    }
    public void removeSubProject() throws IOException {
        Files.deleteIfExists(Paths.get("DataFiles/Users/" + this.getUser().getUsername() + "/SubProjects/" + this.getTitle()));
    }

}


