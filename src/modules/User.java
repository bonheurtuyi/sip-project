package modules;


public abstract class User{
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password; // This should be hashed

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public static void userLogin(){
    }

}
