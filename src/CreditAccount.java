public class CreditAccount extends BankAccount {
    private double creditLimit = 5000;

    public CreditAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);

    }
    @Override
        public boolean withdraw(double amount) {
        return super.withdraw(amount, -creditLimit);
        }

    @Override
        public String getWithdrawalErrorMessage() {
        return "Amount must be positive. Credit balance cannot go below -5000kr";
    }


    @Override
    public void showInfo() {
        System.out.println("------------------------------");
        System.out.println("| "+"Account type: Credit account");
        super.showInfo();
    }


}
