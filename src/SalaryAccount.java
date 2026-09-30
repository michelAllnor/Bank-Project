public class SalaryAccount extends BankAccount {
    public SalaryAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    @Override
    public void showInfo() {                                 // Shows the account type and its shared account details.
        System.out.println("------------------------------");
        System.out.println("| "+"Account type: Salary");
        super.showInfo();
    }


}
