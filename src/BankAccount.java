public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;                 // New accounts starts with zero balance

    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0;
    }
    public void showInfo() {
        System.out.println("| "+"Account number: " + accountNumber );
        System.out.println("| "+"Account holder: " + accountHolder );
        System.out.println("| "+"Balance: " + balance + "\n------------------------------");
    }
}
