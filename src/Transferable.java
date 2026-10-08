// Allows an account to transfer money to another account.
public interface Transferable {
    boolean transferTo(BankAccount targetAccount, double amount);
}