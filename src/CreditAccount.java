public class CreditAccount extends BankAccount {
    public CreditAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    @Override
    public void showInfo() {
        System.out.println("------------------------------");
        System.out.println("| "+"Account type: Credit account");
        super.showInfo();
    }


}
