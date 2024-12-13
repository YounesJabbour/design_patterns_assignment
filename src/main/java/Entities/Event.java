package Entities;


public class Event {
    private String agentName;
    private Transaction transaction;

    public Event(Transaction transaction, String agentName) {
        this.transaction = transaction;
        this.agentName = agentName;
    }

    @Override
    public String toString() {
        return "Event{" +
                "agentName='" + agentName + '\'' +
                ", transaction=" + transaction +
                '}';
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getAgentName() {
        return agentName;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}

