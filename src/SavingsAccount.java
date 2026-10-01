public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }
    @Override
    public double calculateInterest() {
        double interest = getBalance() * 2 / 100;
        return interest;
    }
    @Override
    public void showInfo() {
        System.out.println("------------------------------");
        System.out.println("| "+"Account type: Savings");
        super.showInfo();
    }

}
