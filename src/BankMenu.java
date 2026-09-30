import java.util.ArrayList;
import java.util.Scanner;

public class BankMenu {

    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private int nextAccountNumber = 1001;                       // Account number starts at 1001


    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {                                       // Loops the menu
            System.out.println("""
                     == Welcome to Bank GBG ==
                    1. Create account
                    2. List all accounts
                    3. Check balance by account number
                    4. Deposit money
                    5. Withdraw money
                    6. Transfer money
                    7. Exit
                    =========================""");

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
                } catch (
                        NumberFormatException e) {             // Handle input that cannot be converted into an integer.
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

                    boolean validAccountMenuChoice = false;        // Tracks whether the user chose an account type from the list.
                    while (!validAccountMenuChoice) {              // Repeat the account type prompt until the choice is valid.
                        System.out.println("""
                                 - Choose an account type -
                                1. Salary account
                                2. Savings account
                                3. Credit account
                                4. Back to main menu""");
                        System.out.print("Choose an option: ");
                        String accountTypeInput = scanner.nextLine();

                        switch (accountTypeInput) {            // Select an action based on the account type entered.
                            case "1": {
                                String accountNumber = String.valueOf(nextAccountNumber);  // Unique account number for every salary account
                                SalaryAccount salaryAccount = new SalaryAccount(accountNumber, name);
                                accounts.add(salaryAccount);
                                nextAccountNumber++;

                                System.out.println("Salary account created. -- ACCOUNT NUMBER: " + accountNumber + " --");
                                validAccountMenuChoice = true;
                                break;
                            }
                            case "2": {
                                String accountNumber = String.valueOf(nextAccountNumber); // Unique account number for every savings account
                                SavingsAccount savingsAccount = new SavingsAccount(accountNumber, name);
                                accounts.add(savingsAccount);
                                nextAccountNumber++;

                                System.out.println("Savings account created. -- ACCOUNT NUMBER: " + accountNumber + " --");
                                validAccountMenuChoice = true;
                                break;
                            }
                            case "3": {
                                String accountNumber = String.valueOf(nextAccountNumber);  // Unique account number for every credit accoun
                                CreditAccount creditAccount = new CreditAccount(accountNumber, name);
                                accounts.add(creditAccount);
                                nextAccountNumber++;

                                System.out.println("Credit account created. -- ACCOUNT NUMBER: " + accountNumber + " --");
                                validAccountMenuChoice = true;
                                break;
                            }
                            case "4":
                                validAccountMenuChoice = true;
                                break;
                            default:
                                System.out.println("Invalid account type. Please choose 1, 2, 3 or 4.");
                                break;
                        }
                    }
                    break;
                }
                case 2:
                    if (accounts.isEmpty()) {                   // Display information for every account in the list.
                        System.out.println("No accounts have been created yet.");
                    } else {
                        for (BankAccount account : accounts) {
                            account.showInfo();
                            System.out.println();
                        }
                    }
                    break;
                case 7:
                    System.out.println("Bye!");
                    running = false;
                    break;

                default: // Handle menu options that are not implemented yet.
                    System.out.println("This option is not implemented yet.");
                    break;
            }
        }
    }
}
