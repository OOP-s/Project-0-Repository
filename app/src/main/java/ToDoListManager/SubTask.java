package ToDoListManager;

public class subTask extends Task {

    private parentTask;

    protected subTask(string title, String description, Task parentTask) {
        super(title, description);
        parent = parentTask;
    }

    public subTask newsubTask(String title, String description, Project parentTask) {
        return new subTask(title,description,parentProject);
    }

    public Task getparentTask() {
        return parent;
    }
    public void setparentTask(Task task) { parent = task; }

    public String toString() {
        return "subTask [ Title: "+getTitle()+", Description: "+ getDescription() +"\n"
                +" linkedItem " + linkedItem.toString() +"\n" +
                " Parent " + parent.getTitle() + "]";
    }

}