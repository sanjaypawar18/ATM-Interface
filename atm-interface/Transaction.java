import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return date + " | " + type + " | ₹" + amount;
    }
}