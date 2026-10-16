public class SavingsAccount extends BankAccount implements Transferable  {
    // Create a savings account with the shared account details.
    public SavingsAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    // Estimate one year's interest at 2% without changing the balance.
    @Override
    public double calculateInterest() {
        return getBalance() * 2 / 100;
    }
    // Display the savings account type, interest rate, and account information.
    @Override
    public void showInfo() {
        System.out.println("------------------------------");
        System.out.println("| "+"Account type: Savings");
        System.out.println("| "+"Interest rate: 2%");
        System.out.println("| "+"Estimated annual interest: " + calculateInterest() + "kr");
        super.showInfo();
    }

}
