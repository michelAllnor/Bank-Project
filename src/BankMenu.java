import java.util.ArrayList;
import java.util.Scanner;

public class BankMenu {

    private ArrayList<BankAccount> accounts = new ArrayList<>();


    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                 == Welcome to Bank GBG ==
                1. Create account
                2. List all accounts
                3. Check balance by account number
                4. Deposit money
                5. Withdraw money
                6. Transfer money
                7. Exit
                """);

        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {                       // Keep asking until user made a valid choice
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input);
                validChoice = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }

        switch (choice) {
            case 1:
                System.out.print("[Thank you for choosing Bank GBG!] \nPlease enter your name: ");
                String name = scanner.nextLine();
                if (name.isBlank()) {
                    System.out.println("Name cannot be blank!");
                } else {
                    System.out.println("Welcome, " + name);
                    System.out.println("""
                            1. - Salary account
                            2. - Savings account
                            3. - Credit account""");
                    System.out.print("Choose your account type you want to create: ");
                    String accountTypeInput = scanner.nextLine();
                    switch (accountTypeInput) {
                        case "1":
                            System.out.println("Salary account selected");
                            break;
                        case "2":
                            System.out.println("Savings account selected");
                            break;
                        case "3":
                            System.out.println("Credit account selected");
                            break;
                        default:
                            System.out.println("Invalid account type.");
                            break;
                    }
                }
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }

    }
}
