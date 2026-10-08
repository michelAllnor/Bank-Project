import java.util.ArrayList;
import java.util.Scanner;

public class BankMenu {

    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private int nextAccountNumber = 1001;                       // Account numbers starts at 1001

    // Find and return an account with this account number.
    private BankAccount findAccountByNumber(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Create and save the account type selected by the user.
    private void createAccount(String name, String accountTypeInput) {
        String accountNumber = String.valueOf(nextAccountNumber);
        BankAccount account;
        String accountType;
        switch (accountTypeInput) {                             // Create the selected account type.
            case "1":
                account = new SalaryAccount(accountNumber, name);
                accountType = "Salary";
                break;
            case "2":
                account = new SavingsAccount(accountNumber, name);
                accountType = "Savings";
                break;
            case "3":
                account = new CreditAccount(accountNumber, name);
                accountType = "Credit";
                break;
            default:
                return;
        }
        accounts.add(account);      // Save the account and prepare the next account number.
        nextAccountNumber++;
        System.out.println(accountType + " account created. -- ACCOUNT NUMBER: "
                + accountNumber + " --");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {                                       // Repeat the main menu until the user exits.
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

                        switch (accountTypeInput) {
                            case "1":
                            case "2":
                            case "3": {
                                createAccount(name, accountTypeInput);
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
                    if (accounts.isEmpty()) {                   // Check wether the account list is empty.
                        System.out.println("No accounts have been created yet.");
                    } else {
                        for (BankAccount account : accounts) {      // Display the created accounts.
                            account.showInfo();
                            System.out.println();
                        }
                    }
                    break;

                case 3: {
                    System.out.print("Enter account number: ");
                    String accountNumberInput = scanner.nextLine();
                    // Find the account entered by the user.
                    BankAccount selectedAccount = findAccountByNumber(accountNumberInput);

                    if (selectedAccount == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.println("*************************"
                                + "\n* Account number: " + selectedAccount.getAccountNumber());
                        System.out.println("* Balance: " + selectedAccount.getBalance()
                                + " kr" + "\n*************************");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter account number: ");
                    String accountNumberInput = scanner.nextLine();
                    // Find the account entered by the user.
                    BankAccount selectedAccount = findAccountByNumber(accountNumberInput);

                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                    } else {
                        boolean depositCompleted = false;

                        while (!depositCompleted) {
                            System.out.print("Enter deposit amount: ");
                            String amountInput = scanner.nextLine();

                            try {
                                double amount = Double.parseDouble(amountInput);

                                if (selectedAccount.deposit(amount)) {
                                    System.out.println("Deposit successful.");
                                    depositCompleted = true;
                                } else {
                                    System.out.println("Amount must be greater than zero. Please try again.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number. Try again.");
                            }
                        }
                    }
                    break;
                }

                case 5: {
                    System.out.print("Enter account number: ");
                    String accountNumberInput = scanner.nextLine();
                    // Find the account entered by the user.
                    BankAccount selectedAccount = findAccountByNumber(accountNumberInput);

                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                    } else {
                        boolean withdrawalCompleted = false;

                        while (!withdrawalCompleted) {
                            System.out.print("Enter withdrawal amount: ");
                            String amountInput = scanner.nextLine();

                            try {
                                double amount = Double.parseDouble(amountInput);

                                if (selectedAccount.withdraw(amount)) {
                                    System.out.println("Withdrawal successful. Remaining balance: "
                                            + selectedAccount.getBalance() + " kr");
                                    withdrawalCompleted = true;
                                } else {
                                    System.out.println(selectedAccount.getWithdrawalErrorMessage());
                                    withdrawalCompleted = true;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number. Try again.");
                            }
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.print("Enter the sender's account number: ");
                    String senderNumber = scanner.nextLine();
                    BankAccount senderAccount = findAccountByNumber(senderNumber);

                    if (senderAccount == null) {
                        System.out.println("Sender account not found.");
                        break;
                    }

                    System.out.print("Enter the receiver's account number: ");
                    String receiverNumber = scanner.nextLine();
                    BankAccount receiverAccount = findAccountByNumber(receiverNumber);

                    if (receiverAccount == null) {
                        System.out.println("Receiver account not found.");
                        break;
                    }

                    System.out.print("Enter transfer amount: ");
                    String amountInput = scanner.nextLine();

                    try {
                        double amount = Double.parseDouble(amountInput);
                        Transferable transferSource = (Transferable) senderAccount;

                        if (transferSource.transferTo(receiverAccount, amount)) {
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Transfer failed. Check the amount and the sender account's balance or credit limit.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }

                    break;
                }
                case 7:
                    System.out.println("Have a good day!");
                    running = false;
                    break;

                default: // Handle menu options that are not implemented yet.
                    System.out.println("This option is not implemented yet.");
                    break;
            }
        }
    }
}
