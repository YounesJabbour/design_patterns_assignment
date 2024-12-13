package Entities;

import Observer.Observable;
import Observer.Observer;
import Strategy.Strategy;
import aspects.Cachable;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agent implements Observable, Observer {
    private String name;
    private List<Transaction> transactions;
    private List<Observer> observers;
    private Strategy strategy;

    public void setName(String name) {
        this.name = name;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Agent(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.observers = new ArrayList<>();
    }


    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);

        this.notifyObservers(new Event(transaction, this.name));
    }

    public void applyStrategy(Event event) {
    if(this.strategy != null)
        this.strategy.execute(event);
    }


    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(Event event) {
        for (Observer observer : this.observers) {
            observer.update(event);
        }
    }

    @Override
    public void update(Event event) {
        this.applyStrategy(event);
    }

    public void displayInfo() {
        System.out.println("Agent Name: " + this.name);
        if(!transactions.isEmpty()) {
            System.out.println("Transactions:");
            for (Transaction transaction : this.transactions) {
                System.out.println(transaction);
            }
        }

    }

    @Cachable
    public Transaction getMaxTransaction() {
        return this.transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getAmount))
                .orElse(null);
    }
}