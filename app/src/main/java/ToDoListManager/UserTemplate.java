package ToDoListManager;

public abstract class UserTemplate {
    //variables common to both admin and user
    protected String email;
    protected String password;

    protected  UserTemplate (){

    }
    // constructor for abstract user template class
    protected UserTemplate (String email, String password) {
        this.email = email;
        this.password = password;
    }

//function to check login still needs to be completed.
    public boolean checkLogin(String email, String password) {
        //use search method to find user account that matches email.
        //if(search method finds nothing) {
        // return false;
        //}
        // if (password = user.password) {
        return true;
        // }
        // else { return false:}
    }
}
