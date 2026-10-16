public class SalaryAccount extends BankAccount implements Transferable {
    // Create a salary account with the shared account details.
    public SalaryAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    // Add a bonus for each full 1,000 kr in one deposit.
    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        int bonus = (int) (amount / 1000);
        boolean successful = super.deposit(amount + bonus);
        if (successful && bonus > 0) {
            System.out.println("CONGRATULATIONS! Salary bonus added: " + bonus
                    + " kr (1 kr for every full 1,000 kr deposited).");
        }
        return successful;
    }
    // Display the salary account type and its shared information.
    @Override
    public void showInfo() {
        System.out.println("------------------------------");
        System.out.println("| " + "Account type: Salary");
        super.showInfo();
    }


}
