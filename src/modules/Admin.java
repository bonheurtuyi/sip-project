package modules;

import controllers.UserController;

import java.util.Scanner;
import java.util.UUID;

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

    //Register a patient to the system
    public String initiateRegistration() {
        Scanner regPatient = new Scanner(System.in);

        // admin enters user email
        System.out.println("Enter patient's email: ");
        String userEmail = regPatient.next();

        // system generates UUID
        String uuidString = UUID.randomUUID().toString();

        // system updates the user-store.txt file with the new user email and UUID using
        // the [user_reg.sh] script
        Patient patient = new Patient(uuidString, userEmail);
        userController.storeUserDataToFile(patient);

        // show the UUID to the admin
        System.out.println("User Email: " + userEmail);
        System.out.println("User UUID: " + uuidString);
        return uuidString;
    }
}