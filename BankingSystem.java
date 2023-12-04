import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Bank {
    private Map<Integer, Double> accounts;
    private int accountNumber;

    public Bank() {
        accounts = new HashMap<>();
        accountNumber = 1000; // Starting account number
    }

    public int createAccount(double initialDeposit) {
        accountNumber++;
        accounts.put(accountNumber, initialDeposit);
        return accountNumber;
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            accounts.put(accountNumber, currentBalance + amount);
            System.out.println("Deposited " + amount + " into Account " + accountNumber);
        } else {
            System.out.println("Account does not exist.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawn " + amount + " from Account " + accountNumber);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account does not exist.");
        }
    }

    public void checkBalance(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            double balance = accounts.get(accountNumber);
            System.out.println("Account " + accountNumber + " has a balance of " + balance);
        } else {
            System.out.println("Account does not exist.");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter initial deposit amount: ");
                    double initialDeposit = scanner.nextDouble();
                    int accountNumber = bank.createAccount(initialDeposit);
                    System.out.println("Account created successfully. Account Number: " + accountNumber);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccount = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositAccount, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccount = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(withdrawAccount, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    int checkAccount = scanner.nextInt();
                    bank.checkBalance(checkAccount);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
        System.out.println("Exiting the banking system. Thank you!");
        scanner.close();
    }
}
