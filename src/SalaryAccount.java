public class SalaryAccount extends BankAccount implements Transferable {
    public SalaryAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        int bonus = (int) (amount / 1000);                  // Count the full 1,000 kr units in this deposit.
        boolean successful = super.deposit(amount + bonus);
        if (successful && bonus > 0) {
            System.out.println("CONGRATULATIONS! Salary bonus added: " + bonus
                    + " kr (1 kr for every full 1,000 kr deposited).");    // Add 1 kr for every full 1,000 kr deposited in one transaction.
        }
        return successful;
    }

    @Override
    public void showInfo() {                                 // Shows the account type and its shared account details.
        System.out.println("------------------------------");
        System.out.println("| " + "Account type: Salary");
        super.showInfo();
    }


}
