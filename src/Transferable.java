public interface Transferable {
    // Defines a transfer from one account to another.
    boolean transferTo(BankAccount targetAccount, double amount);
}