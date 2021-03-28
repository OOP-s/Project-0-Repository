package ToDoListManager;
import java.util.LinkedList;

public abstract class itemList {

    private String title;
    private String description;
    private LinkedList<testItem> linkedItemList = new LinkedList<testItem>();

    public itemList(String t, String d) {
        title = t;
        description = d;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public void setTitle(String newTitle) { title = newTitle; }
    public void setDescription(String newDescription) { description = newDescription; }
    public void addItem(testItem item) { linkedItemList.add(item); }
    protected void removeItem(testItem item) { linkedItemList.remove(item); }
    // Remove Item needs to also remove the item from the project in the Gson file
    public void sortListbyDueDate() {  }
    public void sortListbyPriority() {  }
    public void sortListbyLabels(String label) {  }
    public void showCompletedTasks() {  }
    public void removeItemList() {  }

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

}
