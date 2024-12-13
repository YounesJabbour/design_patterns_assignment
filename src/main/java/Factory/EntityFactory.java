package Factory;

import Entities.Agent;
import Entities.Transaction;
import enums.TransactionType;

import java.util.Date;

public class EntityFactory {
    public static Agent createAgent(String name) {
        return new Agent(name);
    }

    public static Transaction createTransaction(String transactionId, Date date, double amount, TransactionType type) {
        return new Transaction.Builder()
                .transactionId(transactionId)
                .date(date)
                .amount(amount)
                .type(type)
                .build();
    }
}