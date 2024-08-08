import controllers.MenuController;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Life Prognosis Management Tool");
        MenuController menuController = new MenuController();
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("Select your choice:");
            System.out.println("1. Patient");
            System.out.println("2. Admin");
            System.out.println("3. Help");
            System.out.println("4. Exit");
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
                    System.out.println("Patient");
                    System.out.println("Logging in...");
                    menuController.userMenu();
                    break;
                case 2:
                    System.out.println("Admin");
                    // Admin login logic here
                    break;
                case 3:
                    System.out.println("Help");
                    // Help menu logic here
                    break;
                case 4:
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Invalid input, please try again!");
            }
        } while (mainChoice != 4);

        scanner.close();  // Close the scanner when done
    }
}
