public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder) {

        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException("Account holder name cannot be blank");
        }

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0; // New accounts always start with a zero balance.
    }
    // Deposits a positive amount into the account.
    public void deposit(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }

        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    // OBS!!! Temporary test method for account creation.
    // TODO: Remove this temporary test method when the console menu is working.
    public static void testAccountCreation() {
        try {
            BankAccount account = new BankAccount("1001", "Michel");
            System.out.println("Account created successfully!");
            System.out.println("Balance before deposit: " + account.getBalance());
            account.deposit(500);
            System.out.println("Balance after deposit: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
