package ToDoListManager;

import java.util.LinkedList;

public class User extends UserTemplate {
    //instance variables specific to user class
    private String firstName;
    private String lastName;
    private String biography;
    private PNG profileImage; //still not sure of data type for this
    private LinkedList<String> projectList = new LinkedList<String>();

    // four different constructors since a biography and profile image are optional for the user
    protected User(String username, String password, String firstName, String lastName){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        projectList.add("Today");
        projectList.add("Upcoming");
        projectList.add("Overdue");
        projectList.add("Complete");
    }
    protected User(String username, String password, String firstName, String lastName, String biography){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        projectList.add("Today");
        projectList.add("Upcoming");
        projectList.add("Overdue");
        projectList.add("Complete");
    }
    protected User(String username, String password, String firstName, String lastName, PNG profileImage){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
        projectList.add("Today");
        projectList.add("Upcoming");
        projectList.add("Overdue");
        projectList.add("Complete");
    }
    protected User(String username, String password, String firstName, String lastName, String biography, PNG profileImage){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.profileImage = profileImage;
        projectList.add("Today");
        projectList.add("Upcoming");
        projectList.add("Overdue");
        projectList.add("Complete");
    }


    //getter methods
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getBiography() { return biography; }
    public PNG getProfileImage() { return profileImage; }
    public LinkedList<String> getProjectList() {return projectList;}

    //setter methods
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setBiography(String biography) {
        this.biography = biography;
    }
    public void setProfileImage(PNG profileImage) {
        this.profileImage = profileImage;
    }

    public String toString() {
        return "Username: " +  getUsername() + " Password: " + getPassword() + " Name: " + getFirstName() + " " + getLastName();
    }

    public void addProject(String title) {
        projectList.add(title);
    }
    public void removeProject(String title){
        projectList.remove(title);
    }


}
