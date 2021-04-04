package ToDoListManager;
import java.io.IOException;
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
    protected LinkedList<testItem> linkedItemList = new LinkedList<testItem>();

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
    public void addItem(testItem item, Project project) throws IOException {
        Project newFile = fileRead.projectFileReader(item.getProject().getUser(), item.getProject().getTitle());
        newFile.linkedItemList.add(item);
        project = newFile;
        item.setProject(project);
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
    public void addItem(testItem item, subProject subproject) throws IOException {
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
    public void removeItem(testItem item) throws IOException {
        linkedItemList.remove(item);
        fileRead.writeJSON(item.getProject(), item.getProject().getUser(),item.getProject().getTitle());
    }

// The sort methods iterate through the list, then find matches and move them to the front of the list
    public void sortListByDueDate(LocalDate date) {
        int length = linkedItemList.size();
        testItem itemHolder;
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
        testItem itemHolder;
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
        testItem itemHolder;
        for (int i = 0; i < length; i++)  {
            if (linkedItemList.get(i).getLabels().equalsIgnoreCase(label)) {
                itemHolder = linkedItemList.get(i);
                linkedItemList.remove(i);
                linkedItemList.addFirst(itemHolder);
            }
        }
    }
    public void showCompletedTasks() {  }
    public void removeItemList() throws IOException {
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

}


