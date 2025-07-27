import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account("user123", "1234", 5000.0);

        System.out.println("Welcome to ATM");
        System.out.print("Enter User ID: ");
        String inputId = sc.nextLine();
        System.out.print("Enter PIN: ");
        String inputPin = sc.nextLine();

        if (account.getUserId().equals(inputId) && account.validatePin(inputPin)) {
            System.out.println("Login successful!");
            ATM atm = new ATM(account);
            atm.start();
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }
}