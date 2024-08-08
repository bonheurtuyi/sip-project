package modules;


public abstract class User{
    private String uuid;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private UserRole role;

    //----Getters--------
    public String getUUID(){
        return uuid;
    }
    public String getFirsname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role.name();
    }

    //-------Setters--------
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }

    //-------Abstract Method--------
    public abstract boolean userLogin(String email, String password);

}

