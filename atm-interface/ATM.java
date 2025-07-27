import java.util.Scanner;

public class ATM {
    private Account account;
    private TransactionHistory history;

    public ATM(Account account) {
        this.account = account;
        this.history = new TransactionHistory();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== ATM Menu ====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    history.printHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        history.addTransaction("Withdraw", withdrawAmount);
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    history.addTransaction("Deposit", depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 4:
                    System.out.print("Enter receiver user ID: ");
                    String receiverId = sc.next();
                    Account receiver = new Account(receiverId, "0000", 1000); // Dummy
                    System.out.print("Enter amount to transfer: ₹");
                    double transferAmount = sc.nextDouble();
                    if (account.transfer(receiver, transferAmount)) {
                        history.addTransaction("Transfer", transferAmount);
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Transfer failed. Insufficient balance.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using ATM!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}