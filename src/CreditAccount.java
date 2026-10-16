public class CreditAccount extends BankAccount implements Transferable {
    private double creditLimit = 5000;
    // Create a credit account with the shared account details.
    public CreditAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }
    // Allow withdrawals down to the credit limit.
    @Override
        public boolean withdraw(double amount) {
        return super.withdraw(amount, -creditLimit);
        }
    // Return an error message that explains the credit limit.
    @Override
        public String getWithdrawalErrorMessage() {
        return "Amount must be positive and credit balance cannot go below -5000kr";
    }
    // Display the credit limit and the shared account information.
    @Override
    public void showInfo() {
        System.out.println("------------------------------");
        System.out.println("| "+"Account type: Credit account");
        System.out.println("| "+"Credit limit: "+creditLimit +"kr");
        super.showInfo();
    }


}
