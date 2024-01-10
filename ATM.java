package banking;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        BankAccount userAccount = new BankAccount("89076543", "8787", 1000.0);

        System.out.println("Welcome to the ATM");
        System.out.print("Enter your account number: ");
        String accNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (accNumber.equals(userAccount.getAccountNumber()) && userAccount.validatePin(enteredPin)) {
            System.out.println("Login successful!");
            while (true) {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Your balance is: $" + userAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        userAccount.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        userAccount.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid account number or PIN. Please try again.");
        }
        scanner.close();
    }
	}


