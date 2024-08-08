import modules.Patient;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Life Prognosis Management Tool");
        System.out.println("Select your choice:");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Patient");
            System.out.println("2. Admin");
            System.out.println("3. Help");
            System.out.println("4. Exit");

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    System.out.println("Patient");
                    System.out.println("Logging in...");
                    Patient.userLogin();
                    break;
                case 2:
                    System.out.println("Admin");
                    break;
                case 3:
                    System.out.println("Help");
                    break;
                case 4:
                    System.out.println("Quitting...");
                    scanner.close(); // Close the scanner
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input, please try again!");
            }
        }
    }
}
