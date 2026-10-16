// Stores the shared information and rules for all account types.
public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;
    // Create an account with a number and an owner. The balance starts at zero.
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0;
    }
    // Add money only when the amount is positive.
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }
    // Withdraw money without allowing the balance to go below zero.
    public boolean withdraw(double amount) {
        return withdraw(amount, 0);
    }
    // Check a withdrawal against the lowest allowed balance.
    public boolean withdraw(double amount, double minimumBalance) {
        if (amount <= 0 || balance - amount < minimumBalance) {
            return false;
        }
        balance -= amount;
        return true;
    }
    // Transfer money to another account if the transfer is allowed.
    public boolean transferTo(BankAccount targetAccount, double amount) {
        if (targetAccount == null || targetAccount == this || amount <= 0) {
            return false;
        }
        if (!withdraw(amount)) {
            return false;
        }

        targetAccount.balance += amount;
        return true;
    }
    // Return the standard error message for a rejected withdrawal.
    public String getWithdrawalErrorMessage() {
        return "Amount must be positive and cannot exceed the available balance.";
    }
    // Display the account's shared information.
    public void showInfo() {
        System.out.println("| " + "Account number: " + accountNumber);
        System.out.println("| " + "Account holder: " + accountHolder);
        System.out.println("| " + "Balance: " + balance + "kr" + "\n------------------------------");
    }

    public double calculateInterest() {
        return 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
