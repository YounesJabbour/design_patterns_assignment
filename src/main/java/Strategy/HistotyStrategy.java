package Strategy;

import Entities.Event;
import Entities.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistotyStrategy implements Strategy{
    private List<Transaction> history = new ArrayList<>();

    @Override
    public void execute(Event event) {
        Transaction transaction = event.getTransaction();
        history.add(transaction);
        System.out.println("HistoryStrategy: Entities.Transaction ajoutée à l'historique - " + transaction);
    }

    public List<Transaction> getHistory() {
        return history;
    }
    public void setHistory(List<Transaction> history) {
        this.history = history;
    }
    public void resetHistory() {
        this.history.clear();
    }
}
