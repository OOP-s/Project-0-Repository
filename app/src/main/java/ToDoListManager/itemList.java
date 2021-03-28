package ToDoListManager;
import java.util.LinkedList;

public abstract class itemList {
// The title and description of the project
    private String title;
    private String description;
// This linked list is going to be the actual data structure that holds the items
    private LinkedList<testItem> linkedItemList = new LinkedList<testItem>();
// Abstract constructor
    public itemList(String t, String d) {
        title = t;
        description = d;
    }
// Get-er and Set-er methods for title and description
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public void setTitle(String newTitle) { title = newTitle; }
    public void setDescription(String newDescription) { description = newDescription; }
// This add item method adds the inputted item into the linked list at the end
    public void addItem(testItem item) { linkedItemList.add(item); }
// Remove item searches for the fist instance of the inputted item and removes it
    protected void removeItem(testItem item) { linkedItemList.remove(item); }
// Remove Item needs to also remove the item from the project in the Gson file
    public void sortListbyDueDate() {  }
    public void sortListbyPriority() {  }
    public void sortListbyLabels(String label) {  }
    public void showCompletedTasks() {  }
    public void removeItemList() {  }

// TEST CLASS WHILE ITEM IS BEING WORKED ON
    static class testItem {
        private String title;
        private String description;
        testItem(String t, String d) {
            title = t;
            description = d;
        }
        public String getTitle() {
            return title;
        }
        public String getDescription() {
            return description;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String toString() {
            return "testItem [ title: "+title+", description: "+ description+ " ]";
        }
    }
//END OF TEST CLASS

}
