 class BankAccount {
    // Private instance variables
    private String accountNumber;
    private double balance;
    private String ownerName;
    private String ownerAddress;

    // Constructor to initialize the account
    public BankAccount(String accountNumber, double initialBalance, String ownerName, String ownerAddress) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
    }

    // Getter methods for read-only access
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}


public class EncapsulationExample {
    public static void main(String[] args) {
        // Creating an instance of the BankAccount class
        BankAccount myAccount = new BankAccount("123456", 1000.0, "John Doe", "123 Main St");

        // Accessing information using getter methods
        System.out.println("Account Number: " + myAccount.getAccountNumber());
        System.out.println("Owner: " + myAccount.getOwnerName());
        System.out.println("Balance: $" + myAccount.getBalance());

        // Making a deposit
        myAccount.deposit(500.0);

        // Making a withdrawal
        myAccount.withdraw(200.0);
    }
}
