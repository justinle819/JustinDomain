package ValueObject;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    private int amount;
    private UUID from;
    private UUID to;
    private Date createdAt;

    public Transaction(int amount, UUID from, UUID to, Date createdAt) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.createdAt = createdAt;
    }
}
