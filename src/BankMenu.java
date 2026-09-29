import java.util.Scanner;

public class BankMenu {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
        Welcome to Bank GBG
        1. Create account
        2. List all accounts
        3. Check balance by account number
        4. Deposit money
        5. Withdraw money
        6. Transfer money
        7. Exit
        """);

        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input);
                validChoice = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }

    }
}
