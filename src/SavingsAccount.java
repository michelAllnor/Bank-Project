public class SavingsAccount extends BankAccount implements Transferable  {
    public SavingsAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }
    @Override
    public double calculateInterest() {
        return getBalance() * 2 / 100;             // Estimate one year's interest without changing the account balance.
    }
    @Override
    public void showInfo() {
        System.out.println("------------------------------");
        System.out.println("| "+"Account type: Savings");
        System.out.println("| "+"Interest rate: 2%");
        System.out.println("| "+"Estimated annual interest: " + calculateInterest() + "kr");
        super.showInfo();
    }

}
