    // ---------------- BankAccount Class ----------------
public class BankAccount {
    private String accountNumber;
    private int balance;
    private int password;

    // Constructor
    public BankAccount(String accountNumber, int balance, int password) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int getPassword() {
        return password;
    }

    // Setters
    public void setBalance(int newBalance) {
        if (newBalance >= 0) {
            balance = newBalance;
        } else {
            System.out.println(" Balance cannot be negative!");
        }
    }

    public void setPassword(int newPassword) {
        if (String.valueOf(newPassword).length() == 4) { // simple 4-digit validation
            password = newPassword;
            System.out.println(" Password changed successfully!");
        } else {
            System.out.println(" Password must be 4 digits!");
        }
    }

    // Withdraw method
    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println(" Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println(" Insufficient balance!");
        } else {
            setBalance(balance - amount); // update via setter
            System.out.println("Withdrawal successful! Remaining balance: " + balance);
        }
    }
}
