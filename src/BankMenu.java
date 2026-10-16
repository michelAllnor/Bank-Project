import java.util.ArrayList;
import java.util.Scanner;

public class BankMenu {

    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private int nextAccountNumber = 1001;

    // Create and save the account type selected by the user.
    private void createAccount(String name, String accountTypeInput) {
        String accountNumber = String.valueOf(nextAccountNumber);
        BankAccount account;
        String accountType;
        // Choose which account class to create.
        switch (accountTypeInput) {
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

    // Find an account by its number, or return null if it is not found.
    private BankAccount findAccountByNumber(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Run the menu and handle the user's choices.
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        // Keep showing the main menu until the user exits.
        while (running) {
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
            boolean validChoice = false;
            // Ask again until the user enters a valid menu number.
            while (!validChoice) {
                System.out.print("Choose an option: ");
                String input = scanner.nextLine();
            // Try to convert the user's text input into an integer.
                try {
                    choice = Integer.parseInt(input);

                    if (choice >= 1 && choice <= 7) {
                        validChoice = true;
                    } else {
                        System.out.println("Choose a number from 1 to 7.");
                    }
                } catch (
                        NumberFormatException e) {
                    System.out.println("Please enter a number.");
                }
            }
            // Run the action selected from the main menu.
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
                    } while (name.isBlank());
                    System.out.println("Welcome, " + name);

                    boolean validAccountMenuChoice = false;
                    while (!validAccountMenuChoice) {
                        System.out.println("""
                                 - Choose an account type -
                                1. Salary account
                                2. Savings account
                                3. Credit account
                                4. Back to main menu""");
                        System.out.print("Choose an option: ");
                        String accountTypeInput = scanner.nextLine();
                        // Create the selected account or return to the main menu.
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
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts have been created yet.");
                    } else {
                        for (BankAccount account : accounts) {
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
                    // Find the account that will send the money.
                    BankAccount senderAccount = findAccountByNumber(senderNumber);

                    if (senderAccount == null) {
                        System.out.println("Sender account not found.");
                        break;
                    }

                    System.out.print("Enter the receiver's account number: ");
                    String receiverNumber = scanner.nextLine();
                    BankAccount receiverAccount = findAccountByNumber(receiverNumber);
                    // Find the account that will receive the money.
                    // Stop if the receiver account was not found.
                    if (receiverAccount == null) {
                        System.out.println("Receiver account not found.");
                        break;
                    }

                    System.out.print("Enter transfer amount: ");
                    String amountInput = scanner.nextLine();

                    try {
                        double amount = Double.parseDouble(amountInput);
                        // Use the shared interface to transfer money from the selected account.
                        Transferable transferSource = (Transferable) senderAccount;
                        // The transfer method checks the sender's rules and updates both accounts.
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
