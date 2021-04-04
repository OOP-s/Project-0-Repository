package ToDoListManager;

public class Admin extends UserTemplate {
// constructor for admin class
    public Admin () {
       super.username = "Admin";
       super.password = "password";
    }
// method for change password in Admin class.
    public boolean changePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        return true;
    }

}
