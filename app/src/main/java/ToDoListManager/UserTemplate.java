package ToDoListManager;

public abstract class UserTemplate {
    //variables common to both admin and user
    protected String username;
    protected String password;

    protected  UserTemplate (){

    }
    // constructor for abstract user template class
    protected UserTemplate (String username, String password) {
        this.username = username;
        this.password = password;
    }


//function to check login still needs to be completed.
    public boolean checkLogin(String username, String password) {
        if( this.username == username && this.username == password){
            return true;
        }
        else{return false;}
    }
}
