public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;                 // New accounts start with zero balance

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0;
    }
    public boolean deposit(double amount) {                 // Add money only when the amount is greater than zero.
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }
    public boolean withdraw(double amount) {
        if (amount <= 0 ||  amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void showInfo() {
        System.out.println("| " + "Account number: " + accountNumber);
        System.out.println("| " + "Account holder: " + accountHolder);
        System.out.println("| " + "Balance: " + balance +"kr"+ "\n------------------------------");
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
