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
        boolean validChoice = false;                           // Tracks whether the menu input is a valid choice.

        while (!validChoice) {                                 // Repeat the prompt until the input is valid.
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            try {                                             // Try to convert the user's text input into an integer.
                choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= 7) {
                    validChoice = true;
                } else {
                    System.out.println("Choose a number from 1 to 7.");
                }
            } catch (NumberFormatException e) {             // Handle input that cannot be converted into an integer.
                System.out.println("Please enter a number.");
            }
        }

        switch (choice) {
            case 1: {
                System.out.println("[Thank you for choosing Bank GBG!]");

                String name;
                do {                                        // Ask for a name at least once before checking it.
                    System.out.print("Please enter your name: ");
                    name = scanner.nextLine();

                    if (name.isBlank()) {
                        System.out.println("Name cannot be blank. Please try again.");
                    }
                } while (name.isBlank());                   // Repeat the name prompt while the name is blank.
                System.out.println("Welcome, " + name);

                boolean validAccountType = false;        // Tracks whether the user chose an account type from the list.
                while (!validAccountType) {              // Repeat the account type prompt until the choice is valid.
                    System.out.println("""
                            Choose an account type:
                            1. Salary account
                            2. Savings account
                            3. Credit account
                            """);
                    System.out.print("Choose an option: ");
                    String accountTypeInput = scanner.nextLine();

                    switch (accountTypeInput) {            // Select an action based on the account type entered.
                        case "1":
                            System.out.println("Salary account selected");
                            validAccountType = true;
                            break;
                        case "2":
                            System.out.println("Savings account selected");
                            validAccountType = true;
                            break;
                        case "3":
                            System.out.println("Credit account selected");
                            validAccountType = true;
                            break;
                        default:
                            System.out.println("Invalid account type. Please choose 1, 2, or 3.");
                            break;
                    }
                }
                break;
            }
            default:                                // Handle input that does not match any listed account type.
                System.out.println("Invalid choice.");
                break;
        }
    }
}
