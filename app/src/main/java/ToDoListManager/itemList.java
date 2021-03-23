package ToDoListManager;

public abstract class itemList {

    private String title;
    private String description;

    public itemList(String t, String d) {
        title = t;
        description = d;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public void setTitle(String newTitle) { title = newTitle; }
    public void setDescription(String newDescription) { description = newDescription; }
    public void sortListbyDueDate() {  }
    public void sortListbyPriority() {  }
    public void sortListbyLabels(String label) {  }
    public void showCompletedTasks() {  }
    public void removeItemList() {  }

}
