package OPG3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Rental {
    private double pricePerDay;
    private int number;
    private int days;
    private LocalDate startDate;

    public Rental(int number, int days, double price, LocalDate startDate) {
        this.number = number;
        this.days = days;
        this.pricePerDay = price;
        this.startDate = startDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return startDate.plusDays(getDays());
    }

    public double getTotalPrice() {
        return number * (days * pricePerDay);
    }
}
