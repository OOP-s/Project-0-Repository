package ToDoListManager;

public class User extends UserTemplate {
    //instance variables specific to user class
    private String firstName;
    private String lastName;
    private String biography;
    private PNG profileImage; //still not sure of data type for this


    // four different constructors since a biography and profile image are optional for the user
    public User(String username, String password, String firstName, String lastName){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User(String username, String password, String firstName, String lastName, String biography){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }
    public User(String username, String password, String firstName, String lastName, PNG profileImage){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
    }
    public User(String username, String password, String firstName, String lastName, String biography, PNG profileImage){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.profileImage = profileImage;
    }
    //getter methods
    public String getUsername() { return username;}
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getBiography() {
        return biography;
    }
    public PNG getProfileImage() {
        return profileImage;
    }

    //setter methods
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }
    public void setProfileImage(PNG profileImage) {
        this.profileImage = profileImage;
    }


}
