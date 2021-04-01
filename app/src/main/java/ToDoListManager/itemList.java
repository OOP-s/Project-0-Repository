package ToDoListManager;
import java.io.IOException;
import java.util.LinkedList;

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
        linkedItemList.add(item);
        item.setProject(project);
        fileRead.writeJSON(item.getProject(),item.getProject().getTitle());
    }
    public void addItem(testItem item, subProject subproject) throws IOException {
        linkedItemList.add(item);
        item.setProject(subproject);
        fileRead.writeJSON(item.getProject(),item.getProject().getTitle());
    }

// Remove item searches for the first instance of the inputted item and removes it
    public void removeItem(testItem item) throws IOException {
        linkedItemList.remove(item);
        fileRead.writeJSON(item.getProject(),item.getProject().getTitle());
    }

// Add and Remove Item needs to also remove the item from the project in the Gson file
    public void sortListbyDueDate() {  }
    public void sortListbyPriority() {  }
    public void sortListbyLabels(String label) {  }
    public void showCompletedTasks() {  }
    public void removeItemList() {  }

}


