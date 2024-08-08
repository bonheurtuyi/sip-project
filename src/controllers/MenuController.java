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
                System.out.println("******************************");
                System.out.println("HIV Life Expectancy Menu for Admin:");
                System.out.println("1. Register a Patient");
                System.out.println("2. Download Data(csv)");
                System.out.println("3. Logout");
                System.out.println("*********************************");

                System.out.print("Select Your Option Now: ");

                if (scanner.hasNextInt()) {
                    adminOption = scanner.nextInt();
                } else {
                    scanner.next();
                    System.out.println("Only numbers can be entered");
                    adminOption = 0;
                }

                switch (adminOption) {
                    case 1:
                        System.out.println("initiate registration");;
                        break;
                    case 2:
                        System.out.println("Download CSV");;
                        break;
                    case 3:
                        System.out.println("Logged out");
                        break;
                    default:
                        System.out.println("You selected an invalid option");
                        break;
                }
            } while (adminOption != 3);

        }

        /* Patient Menu **/
        else if (patient.userLogin(email, password)) {
            int option = 0;

            do {
                System.out.println("******************************");
                System.out.println("HIV Life Expectancy Menu for Patient:");
                System.out.println("1. View Patient Profile");
                System.out.println("2. Edit Patient Profile");
                System.out.println("3. Logout");
                System.out.println("*********************************");

                System.out.print("Select Your Option Now: ");

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

