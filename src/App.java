import controllers.MenuController;
import controllers.UserController;
import modules.Admin;

import java.util.Scanner;
import modules.Patient;

public class App {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        UserController userController = new UserController();
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Life Prognosis Management Tool");

        int mainChoice;

        do {
            System.out.println("Select your choice:");
            System.out.println("1. Complete registration");
            System.out.println("2. Patient");
            System.out.println("3. Admin");
            System.out.println("4. Help");
            System.out.println("5. Exit");
            System.out.print("Input your choice: ");

            // Check if the input is an integer
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();  // Clear the invalid input
                System.out.print("Input your choice: ");
            }
            mainChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (mainChoice) {
                case 1:
                    System.out.println("Complete registration");
                    Patient patient = new Patient();
                    patient.storeUserDataToFile();
                    break;
                case 2:
                    System.out.println("Patient logging in...");
                    menuController.userMenu();
                    break;
                case 3:
                    System.out.println("Admin logging in...");
                    menuController.userMenu();
                    break;
                case 4:
                    System.out.println("Help");
                    // Help menu logic here
                    break;
                case 5:
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Invalid input, please try again!");
            }
        } while (mainChoice != 5);

        scanner.close();  // Close the scanner when done
    }
}
