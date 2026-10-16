# **Project Plan**
Author: Michel Allnor
## Project Idea
A bank account management system where the user can create and manage salary accounts, savings accounts, and credit accounts. The program will support listing and searching for accounts, as well as deposits, withdrawals, and transfers between accounts.

## Superclass
Name: BankAccount

Shared fields: _accountNumber_, _accountHolder_, and _balance_.

Shared methods:
* deposit(amount) - deposits money into the account.
* withdraw(amount) - withdraws money from the account.
* calculateInterest() - calculates interest according to the account type.
* showInfo() - displays account information.

## Subclasses
_SalaryAccount_ - an account that earns no interest and does not allow withdrawals exceeding the available balance. Overrides withdraw(amount) and calculateInterest().

_SavingsAccount_ - an account that calculates estimated annual savings interest without changing the balance. Withdrawals cannot exceed the available balance. Overrides withdraw(amount) and calculateInterest().

_CreditAccount_ - an account that allows a negative balance up to a specified credit limit and calculates estimated annual interest charges on any outstanding debt without changing the balance. Overrides withdraw(amount) and calculateInterest().

## Interface
Name: _Transferable_

Method: transferTo(BankAccount targetAccount, double amount)  transfers an amount from the account to another account.

Implemented by: SalaryAccount and SavingsAccount.

## Menu
1. Create account
2. List all accounts
3. Check balance by account number
4. Deposit money
5. Withdraw money
6. Transfer money
7. Exit

## Error Scenarios

The user enters letters instead of a numeric amount when making a deposit or withdrawal. The program displays an error message and allows the user to try again.

The user attempts to deposit or withdraw an amount that is zero or negative. The program rejects the transaction and explains that the amount must be greater than zero.

The user attempts to withdraw more than the available balance from a salary or savings account, or exceed the credit limit on a credit account. The program rejects the withdrawal without changing the balance.

The user enters an account number that does not exist when making a transfer. The program displays an error message without transferring any money.

# Design Rationale

I put shared account data and methods in BankAccount so all account types can reuse them. SalaryAccount, SavingsAccount and CreditAccount inherit from it and add their own rules.
I use an ArrayList to store the accounts and search for them by account number. 
The Transferable gives the account types a shared method for transferring money.

At first, I wrote a separate account in several menu options. 
After feedback, I moved the search into findAccountByNumber. 
This lets the menu options refuse the same method and avoids repeating the search code.

