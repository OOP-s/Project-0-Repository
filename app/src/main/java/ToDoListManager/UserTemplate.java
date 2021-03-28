package ToDoListManager;

public abstract class UserTemplate {
    protected String email;
    protected String password;

    protected UserTemplate(){
    }

    protected UserTemplate (String email, String password) {
        this.email = email;
        this.password = password;

    }

    public boolean checkLogin(String email, String password){
        //code to fetch email.
        return true;
    }
}
