import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Create a BankAccount object
        BankAccount account = new BankAccount("PKN123-56789", 150000, 1234);

        System.out.println("Welcome to the Bank ATM");

        // Login loop
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter Account Number: ");
            String inputAcc = scan.nextLine();
            System.out.print("Enter Password: ");
            int inputPass = scan.nextInt();
            scan.nextLine(); // consume leftover newline

            if (inputAcc.equals(account.getAccountNumber()) && inputPass == account.getPassword()) {
                System.out.println(" Login Successful!\n");
                loggedIn = true;
            } else {
                System.out.println(" Incorrect credentials. Try again.\n");
            }
        }

        // ATM menu
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Check Balance");
            System.out.println("3. Change Password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    int amount = scan.nextInt();
                    scan.nextLine();
                    account.withdraw(amount); // updates balance using setter
                    break;

                case 2:
                    System.out.println("Your current balance is: " + account.getBalance());
                    break;

                case 3:
                    System.out.print("Enter new password (4-digit): ");
                    int newPass = scan.nextInt();
                    scan.nextLine();
                    account.setPassword(newPass);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
                    break;
            }

        } while (choice != 4);

        scan.close();
    }
}

