package controllers;

import modules.Admin;
import modules.Patient;

import java.util.Scanner;

public class MenuController {
    Scanner scanner = new Scanner(System.in);

    public void userMenu(){
        Admin admin = new Admin();
        Patient patient = new Patient();

        // enter email and password
        System.out.println("Enter your Email: ");
        String email = scanner.next().trim();
        System.out.println("Enter your Password: ");
        String password = scanner.next().trim();

        /* Admin Menu **/
        if (admin.userLogin(email, password)) {
            int adminOption = 0;

            do {
                System.out.println("Welcome Admin:");
                System.out.println("1. Register a Patient");
                System.out.println("2. Generate users' list");
                System.out.println("3. Logout");

                System.out.print("Input choice: ");

                if (scanner.hasNextInt()) {
                    adminOption = scanner.nextInt();
                } else {
                    scanner.next();
                    System.out.println("Only numbers can be entered");
                    adminOption = 0;
                }

                switch (adminOption) {
                    case 1:
                        System.out.println("initiating user registration");
                        admin.initiateRegistration();
                        break;
                    case 2:
                        System.out.println("Download CSV");;
                        break;
                    case 3:
                        System.out.println("Logged out");
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                        break;
                }
            } while (adminOption != 3);

        }

        /* Patient Menu **/
        else if (patient.userLogin(email, password)) {
            int option = 0;

            do {
                System.out.println("Welcome:");
                System.out.println("1. View Profile");
                System.out.println("2. Edit Profile");
                System.out.println("3. Logout");

                System.out.print("Input choice: ");

                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                } else {
                    scanner.next();
                    System.out.println("Only numbers can be entered");
                    option = 0;
                }

                switch (option) {
                    case 1:
                        System.out.println('1');
                        break;
                    case 2:
                        System.out.println('2');
                        break;
                    case 3:
                        System.out.println("Logged out");
                        break;
                    default:
                        System.out.println("You selected an invalid option");
                        break;
                }
            } while (option != 3);

        }

        /* Invalid credentials **/
        else {
            System.out.println("Invalid Email or Password! Try again later!");
        }
    }
}

