package Strategy;

import Entities.Event;
import Entities.Transaction;
import enums.TransactionType;

public class ScoringStrategy implements Strategy{
    private double balance;

    @Override
    public void execute(Event event) {
    Transaction transaction = event.getTransaction();
    double amount = transaction.getAmount();
        if (transaction.getType() == TransactionType.VENTE) {
            balance += amount;
        } else if (transaction.getType() == TransactionType.ACHAT) {
            balance -= amount;
        }
        System.out.println("Strategy.ScoringStrategy: Nouveau solde = " + balance);
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void resetBalance() {
        this.balance = 0;
    }
}
