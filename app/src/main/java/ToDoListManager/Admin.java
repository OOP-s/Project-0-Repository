package ToDoListManager;

public class Admin extends UserTemplate {

    public Admin () {
       super.email = "Admin";
       super.password = "password";
    }

    public boolean changePassword(String email, String newPassword) {
        //code to change password.
        return true;
    }
}
