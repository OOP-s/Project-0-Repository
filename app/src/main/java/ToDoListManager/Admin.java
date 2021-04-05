package ToDoListManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;



public class Admin extends UserTemplate {
// constructor for admin class
    public Admin () {
       super.username = "Admin";
       super.password = "password";
    }
// method for change password in Admin class.
    public boolean changePassword(User user, String newPassword) throws IOException {


        Manager manager = new Manager();
        manager.users = Manager.returnUsers();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        manager.users.remove(user);
        user.setPassword(newPassword);
        manager.users.add(user);

        FileWriter writer = new FileWriter("userInfo/Users");
        writer.write(gson.toJson(manager));
        writer.close();
        return true;
    }

}
