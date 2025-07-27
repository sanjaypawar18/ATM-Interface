import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private List<Transaction> history;

    public TransactionHistory() {
        this.history = new ArrayList<>();
    }

    public void addTransaction(String type, double amount) {
        history.add(new Transaction(type, amount));
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("\n--- Transaction History ---");
            for (Transaction t : history) {
                System.out.println(t);
            }
        }
    }
}