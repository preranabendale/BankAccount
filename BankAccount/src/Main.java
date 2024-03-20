import java.util.Scanner;

// Bank Account class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful.");
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }
}

// ATM class
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM.");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawAmount)) {
                    System.out.println("Remaining balance: $" + bankAccount.getBalance());
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Current balance: $" + bankAccount.getBalance());
                break;
            case 3:
                System.out.println("Your balance is: $" + bankAccount.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a bank account with initial balance of $1000
        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.processOption(choice);
        }
    }
}
