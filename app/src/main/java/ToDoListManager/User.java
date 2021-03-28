package ToDoListManager;

public class User extends UserTemplate {
    private String firstName;
    private String lastName;
    private String biography;
    private PNG profileImage; //still not sure of data type for this


    // four different constructors since a biography and profile image are optional for the user
    public User(String email, String password, String firstName, String lastName){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User(String email, String password, String firstName, String lastName, String biography){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }
    public User(String email, String password, String firstName, String lastName, PNG profileImage){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
    }
    public User(String email, String password, String firstName, String lastName, String biography, PNG profileImage){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this. biography = biography;
        this.profileImage = profileImage;
    }
    //getter methods
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
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
    public void setEmail(String email) {
        this.email = email;
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
