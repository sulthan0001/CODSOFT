import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        balance += amount;
    }

    public boolean withdraw(double amount) 
    {
        if (amount > balance) 
        {
            System.out.println("Insufficient funds.");
            return false;
        } else 
        {
            balance -= amount;
            return true;
        }
    }
}

// Class to represent the ATM machine
class ATM 
{
    private BankAccount userAccount;

    public ATM(BankAccount account) 
    {
        this.userAccount = account;
    }

    public void displayMenu() 
    {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner scanner) 
    {
        switch (choice) 
        {
            case 1:
                // Withdraw
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > 0) 
                {
                    if (userAccount.withdraw(withdrawAmount)) 
                    {
                        System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                    }
                } else 
                {
                    System.out.println("Invalid amount for withdrawal.");
                }
                break;
            case 2:
                // Deposit
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) 
                {
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
                } else 
                {
                    System.out.println("Invalid amount for deposit.");
                }
                break;
            case 3:
                // Check Balance
                System.out.println("Your balance: " + userAccount.getBalance());
                break;
            case 4:
                // Exit
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}

public class Main
{
    public static void main(String[] args) 
    {
        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM instance
        ATM atm = new ATM(userAccount);

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            // Display the ATM menu
            atm.displayMenu();

            // Get user choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Perform the selected transaction
            atm.performTransaction(choice, scanner);
        }
    }
}
