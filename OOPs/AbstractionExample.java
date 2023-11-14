// Step 1: Define an interface for an account
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

// Step 2: Create an abstract class for a generic account
abstract class AbstractAccount implements Account {
    private String accountNumber;
    private double balance;

    public AbstractAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    // Abstract method for specific account type
    public abstract void applyInterest();
}

// Step 3: Implement a concrete class for a Savings Account
class SavingsAccount extends AbstractAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest applied: $" + interest);
    }
}

// Step 4: Implement a concrete class for a Checking Account
class CheckingAccount extends AbstractAccount {
    private static final double OVERDRAFT_FEE = 30.0;

    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            super.withdraw(amount);
        } else if (amount > getBalance()) {
            System.out.println("Insufficient funds. Overdraft fee applied.");
            super.withdraw(OVERDRAFT_FEE);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public void applyInterest() {
        // Checking accounts do not earn interest
        System.out.println("No interest applied to checking account.");
    }
}

// Step 5: Usage of the abstraction in the main program
public class AbstractionExample {
    public static void main(String[] args) {
        // Create a savings account
        Account savingsAccount = new SavingsAccount("SA123", 1000.0, 5.0);
        savingsAccount.deposit(200.0);
        savingsAccount.withdraw(50.0);
        System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());
        ((SavingsAccount) savingsAccount).applyInterest();

        // Create a checking account
        Account checkingAccount = new CheckingAccount("CA456", 500.0);
        checkingAccount.deposit(100.0);
        checkingAccount.withdraw(50.0);
        System.out.println("Checking Account Balance: $" + checkingAccount.getBalance());
        ((CheckingAccount) checkingAccount).applyInterest();
    }
}
