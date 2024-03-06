package OPG4ex107;

import java.time.LocalDate;

public class Account {
    private static double annualInterestRate = 2.5;
    private int id = 0;
    private double balance = 0;
    private LocalDate dateCreated = LocalDate.now();

    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void withdraw(double amount) {
        double balance = getBalance();
        setBalance(balance -= amount);
    }

    public void deposit(double amount) {
        double balance = getBalance();
        setBalance(balance += amount);
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

}
