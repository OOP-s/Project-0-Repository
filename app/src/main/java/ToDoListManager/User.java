package ToDoListManager;

import java.io.IOException;
import java.util.LinkedList;

public class User extends UserTemplate {
    //instance variables specific to user class
    private String firstName;
    private String lastName;
    private String biography;
    private PNG profileImage; //still not sure of data type for this
    private LinkedList projectList = new LinkedList<>();
    private String Name;

    // four different constructors since a biography and profile image are optional for the user
    protected User(String username, String password, String firstName, String lastName){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.Name = firstName+" "+lastName;
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
        this.Name = firstName+" "+lastName;
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
        this.Name = firstName+" "+lastName;
        projectList.add("Today");
        projectList.add("Upcoming");
        projectList.add("Overdue");
        projectList.add("Complete");
    }
    protected User(String username, String password, String firstName, String lastName, String biography, PNG profileImage){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.Name = firstName+" "+lastName;
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
    public String getName() {return Name;}
    public LinkedList getProjectList() throws IOException {return fileRead.projectListReader(this);}

    //setter methods
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Name = firstName+lastName;
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

        try {
            return "[Username: " +  getUsername() + " Password: " + getPassword() + " Name: " + getFirstName() + " " + getLastName() + " Biography: " +
                    getBiography() + " ProjectList: "+ getProjectList() + "]";
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }

    }

    public void addProject(String title) throws IOException {
        projectList = fileRead.projectListReader(this);
        projectList.add(title);
        fileRead.projectListWriter(this);
    }
    public void removeProject(String title) throws IOException {
        projectList = fileRead.projectListReader(this);
        projectList.remove(title);
        fileRead.projectListWriter(this);
    }


}
