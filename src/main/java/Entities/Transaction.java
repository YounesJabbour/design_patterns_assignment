package Entities;

import enums.TransactionType;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private Date date;
    private double amount;
    private TransactionType type;

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    private Transaction(Builder builder) {
        this.transactionId = builder.transactionId;
        this.date = builder.date;
        this.amount = builder.amount;
        this.type = builder.type;
    }

    public static class Builder {
        private String transactionId;
        private Date date;
        private double amount;
        private TransactionType type;

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder type(TransactionType type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
