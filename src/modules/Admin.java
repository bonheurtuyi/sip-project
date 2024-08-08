package modules;

import controllers.UserController;

public class Admin extends User {

    UserController userController = new UserController();

    // Function for Admin Login
    @Override
    public boolean userLogin(String email, String password) {

        // Check if entered details are correct
        if (userController.verifyLoginCredentials(email, password).equals("admin")) {
            System.out.println("Admin Logged in successfully!");
            System.out.println("---");
            return true;
        } else {
            return false;
        }
    }
}